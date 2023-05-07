package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.CategoryPrice;
import com.partner.dataObjects.PriceLumber;
import com.partner.service.PriceServiceControl;
import com.partner.utils.FilterParameters;

@RestController
public class PriceController {
	@Autowired
	private PriceServiceControl priceServiceControl;
	
	@GetMapping(value = "/restApi/price/getAllCategories")
	public List<CategoryPrice> receiveAllCategoriesOfPrice (){
		return priceServiceControl.getAllCategoryPrice();
	}
	
	@GetMapping(value = "/restApi/price/getCategoryById")
	public CategoryPrice receiveCategoryOfPriceById(@RequestParam("id") int id) {
		return priceServiceControl.getCategoryPriceById(id);
	}
	
	@GetMapping(value = "/restApi/price/getAll")
	public List<PriceLumber> receivePrices(){
		return priceServiceControl.geAllPrice();
	}
	
	@GetMapping(value ="/restApi/price/f" )
	public List<PriceLumber> receivePricesByFilter(@RequestParam("p") int page){
		FilterParameters filter = new FilterParameters();
		filter.setStartPrice(0);
		filter.setFinalPrice(110000);
		filter.setNumberPage(page);
		filter.setSortingByAmountOrders(true);
		return priceServiceControl.getPricesByFilter(filter);
	}
}
