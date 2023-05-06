package com.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.CategoryPriceRepository;
import com.partner.dataCrudInterfaces.PriceLumberRepository;
import com.partner.dataObjects.CategoryPrice;
import com.partner.dataObjects.PriceLumber;

@Service
public class PriceServiceControl {
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

	public List<PriceLumber> geAllPrice(){
		List<PriceLumber> prices = new ArrayList<>();
		priceLumberRepository.findAll().iterator().forEachRemaining(prices::add);
		return prices;
	}
	
}
