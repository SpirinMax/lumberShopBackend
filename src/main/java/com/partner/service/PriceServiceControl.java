package com.partner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.partner.dataCrudInterfaces.CategoryPriceRepository;
import com.partner.dataCrudInterfaces.PriceLumberRepository;
import com.partner.dataObjects.CategoryPrice;
import com.partner.dataObjects.PriceLumber;
import com.partner.utils.FilterParameters;
import com.partner.utils.PriceLumberSpecification;
import com.partner.utils.SearchCriteria;

@Service
public class PriceServiceControl {
	private Pageable pageable;
	@Autowired
	private CategoryPriceRepository categoryPriceRepository;

	@Autowired
	private PriceLumberRepository priceLumberRepository;

	protected PriceServiceControl() {

	}

	public void saveCategoryPrice(CategoryPrice categoryPrice) {
		categoryPriceRepository.save(categoryPrice);
	}

	public CategoryPrice getCategoryPriceById(int id) {
		return categoryPriceRepository.findById(id).get();
	}

	public List<CategoryPrice> getAllCategoryPrice() {
		List<CategoryPrice> listCategoriesPrice = new ArrayList<>();
		categoryPriceRepository.findAll().iterator().forEachRemaining(listCategoriesPrice::add);
		return listCategoriesPrice;
	}

	public List<CategoryPrice> getCategoriesPricesWithoutDiscount() {
		List<CategoryPrice> listCategoriesPrice = new ArrayList<>();
		categoryPriceRepository.findDistinctByDiscount(false).iterator().forEachRemaining(listCategoriesPrice::add);
		return listCategoriesPrice;
	}

	public List<PriceLumber> geAllPrice() {
		List<PriceLumber> prices = new ArrayList<>();
		priceLumberRepository.findAll().iterator().forEachRemaining(prices::add);
		return prices;
	}

	public List<PriceLumber> getPricesWithDiscount() {
		List<PriceLumber> prices = new ArrayList<>();
		priceLumberRepository.findByCategoryPrice_Discount(true).iterator().forEachRemaining(prices::add);
		return prices;
	}

	@Transactional
	public List<PriceLumber> getPricesByFilter(FilterParameters filter) {
		List<SearchCriteria> listCriterias = new ArrayList<>();
		Specification<PriceLumber> resultSpec = new PriceLumberSpecification(false);
		int sizeOutput = 6;
		System.out.println(filter.toString());
		if (filter.getCategoryPrice() != null) {
			listCriterias.add(new SearchCriteria("categoryPrice", ":", filter.getCategoryPrice()));
		} else {
			resultSpec = new PriceLumberSpecification(true);
		}
		if (filter.getStartPrice() > 0 && filter.getFinalPrice() == 0) {
			listCriterias.add(new SearchCriteria("price", ">", filter.getStartPrice()));
		}
		if (filter.getFinalPrice() > 0 && filter.getStartPrice() == 0) {
			listCriterias.add(new SearchCriteria("price", "<", filter.getFinalPrice()));
		}
		if (filter.getStartPrice() > 0 && filter.getFinalPrice() > 0) {
			listCriterias.add(new SearchCriteria("price", ">", filter.getStartPrice()));
			listCriterias.add(new SearchCriteria("price", "<", filter.getFinalPrice()));
		}

		Optional<String> categoryLumber = Optional.ofNullable(filter.getCategoryLumber());
		Optional<String> breedWood = Optional.ofNullable(filter.getNameBreed());

		if (filter.getNameLumber() != null) {
			listCriterias.add(new SearchCriteria("nameLumber", ":", filter.getNameLumber()));
		}
		if (categoryLumber.isPresent()) {
			listCriterias.add(new SearchCriteria("categoryLumber", ":", filter.getCategoryLumber()));
		}

		if (breedWood.isPresent()) {
			listCriterias.add(new SearchCriteria("nameBreed", ":", filter.getNameBreed()));
		}

		if (filter.getDiameter() != 0) {
			listCriterias.add(new SearchCriteria("diameter", ":", filter.getDiameter()));
		}

		if (filter.getWidth() != 0) {
			listCriterias.add(new SearchCriteria("width", ":", filter.getWidth()));
		}

		if (filter.getLenght() != 0) {
			listCriterias.add(new SearchCriteria("lenght", ":", filter.getLenght()));
		}

		if (filter.getThickness() != 0) {
			listCriterias.add(new SearchCriteria("thickness", ":", filter.getThickness()));
		}

		if (filter.isAvailDiscount()) {
			listCriterias.add(new SearchCriteria("availDiscount", ":", 1));
		}

		if (filter.isSortingByDiscountDesc()) {
			listCriterias.add(new SearchCriteria("discount_desc_sort", ":", "desc"));
		}

		List<PriceLumberSpecification> spec = new ArrayList<>();
		for (int i = 0; i < listCriterias.size(); i++) {
			System.out.println("SPEC++");
			spec.add(new PriceLumberSpecification(listCriterias.get(i)));
		}

		for (int j = 0; j < spec.size(); j++) {
			resultSpec = Specification.where(resultSpec).and(spec.get(j));
		}

		switch (filter.getParameterSorting()) {
		case ("none"):
			pageable = PageRequest.of(filter.getNumberPage(), sizeOutput);
			break;
		case ("max_price"):
			pageable = PageRequest.of(filter.getNumberPage(), sizeOutput, Sort.by("discountPrice").descending());
			break;
		case ("min_price"):
			pageable = PageRequest.of(filter.getNumberPage(), sizeOutput, Sort.by("discountPrice"));
			break;
		case ("amount_orders"):
			pageable = PageRequest.of(filter.getNumberPage(), sizeOutput, Sort.by("amountOrders").descending());
			break;
		default:
			pageable = PageRequest.of(filter.getNumberPage(), sizeOutput);
		}
		List<PriceLumber> prices = new ArrayList<>();
		List<PriceLumber> recurringPrices = new ArrayList<>();
		priceLumberRepository.findAll(resultSpec, pageable).iterator().forEachRemaining(prices::add);
		// Удаление не скидочного priceLumber из выборки, в случае если в выборке есть
		// другой priceLumber с тем же idLumber, но имеющем скидки
		int[] idDiscountLumberArray = getArrayIdLumberWhoHaveDiscount();
		if (idDiscountLumberArray.length != 1 && idDiscountLumberArray[0] != 0) {
			for (PriceLumber pr : prices) {
				for (int i = 0; i < idDiscountLumberArray.length; i++) {
					if (pr.getLumber().getIdLumber() == idDiscountLumberArray[i]
							&& !pr.getCategoryPrice().isDiscount()) {
						System.out.println("Recurring price without discount! PRICE_ID=" + pr.getIdPrice()
								+ " Deleted from result");
						recurringPrices.add(pr);
					}
				}
			}
			prices.removeAll(recurringPrices);
		}
		return prices;
	}

	private int[] getArrayIdLumberWhoHaveDiscount() {
		List<PriceLumber> pricesWithDiscount = new ArrayList<>();
		pricesWithDiscount = getPricesWithDiscount();
		if (!pricesWithDiscount.isEmpty()) {
			int[] idLumberArray = new int[pricesWithDiscount.size()];
			for (int i = 0; i < pricesWithDiscount.size(); i++) {
				idLumberArray[i] = pricesWithDiscount.get(i).getLumber().getIdLumber();
			}
			return idLumberArray;
		} else {
			return new int[1];
		}
	}

}
