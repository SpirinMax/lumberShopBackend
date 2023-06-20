package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value = "/restApi/price")
	public List<PriceLumber> receivePricesByFilter(@RequestBody FilterParameters filter){
		return priceServiceControl.getPricesByFilter(filter);
	}
	
	@GetMapping(value ="/restApi/price/f" )
	public List<PriceLumber> receivePricesByFilter(@RequestParam("p") int page){
		FilterParameters filter = new FilterParameters();
		//filter.setStartPrice(0);
		//filter.setFinalPrice(1300000);
		filter.setNumberPage(page);
		filter.setCategoryLumber("Брус");
		filter.setNameBreed("Сосна");
		//filter.setSortingByAmountOrders(true);
		//filter.setDiameter(200);
		//filter.setWidth(150);
		//filter.setLenght(6000);
		//filter.setThickness(200);
		//filter.setAvailDiscount(true);
		filter.setSortingByDiscountDesc(true);
		return priceServiceControl.getPricesByFilter(filter);
	}
	
	@GetMapping(value = "/restApi/price/test")
	public List<CategoryPrice> test(){
		return priceServiceControl.getCategoriesPricesWithoutDiscount();
	}
}
