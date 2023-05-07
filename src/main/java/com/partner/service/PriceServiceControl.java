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

	public List<PriceLumber> geAllPrice() {
		List<PriceLumber> prices = new ArrayList<>();
		priceLumberRepository.findAll().iterator().forEachRemaining(prices::add);
		return prices;
	}

	public List<PriceLumber> getPricesByFilter(FilterParameters filter) {
		List<SearchCriteria> listCriterias = new ArrayList<>();
		// Optional.ofNullable(filter.getCategoryPrice()).
//		if (!Optional.ofNullable(filter.getCategoryPrice()).equals(null)) {
//			listCriterias.add(new SearchCriteria("categoryPrice", ":", filter.getCategoryPrice()));
//		}
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

		List<PriceLumberSpecification> spec = new ArrayList<>();
		for (int i = 0; i < listCriterias.size(); i++) {
			System.out.println("SPEC++");
			spec.add(new PriceLumberSpecification(listCriterias.get(i)));
		}
//		PriceLumberSpecification spec1 = new PriceLumberSpecification(
//				new SearchCriteria("categoryPrice", ":", filter.getCategoryPrice()));
//		PriceLumberSpecification spec2 = new PriceLumberSpecification(
//				new SearchCriteria("price", ":", filter.getCategoryPrice()));
//		List<PriceLumber> prices = new ArrayList<>();

		// priceLumberRepository.findAll(spec).iterator().forEachRemaining(prices::add);

		// -----------------
		List<PriceLumber> prices = new ArrayList<>();
		Specification<PriceLumber> resultSpec = new PriceLumberSpecification();
		for (int j = 0; j < spec.size(); j++) {
			resultSpec = Specification.where(resultSpec).and(spec.get(j));
		}

		switch (filter.getParameterSorting()) {
		case ("none"):
			pageable = PageRequest.of(filter.getNumberPage(), 2, Sort.by("idPrice"));
			break;
		case ("max_price"):
			pageable = PageRequest.of(filter.getNumberPage(), 2, Sort.by("discountPrice").descending());
			break;
		case ("min_price"):
			pageable = PageRequest.of(filter.getNumberPage(), 2, Sort.by("discountPrice"));
			break;
		case ("amount_orders"):
			pageable = PageRequest.of(filter.getNumberPage(), 2, Sort.by("amountOrders").descending());
			break;
		default:
			pageable = PageRequest.of(filter.getNumberPage(), 2);
		}
		
		priceLumberRepository.findAll(resultSpec, pageable).iterator().forEachRemaining(prices::add);
		return prices;
	}

}
