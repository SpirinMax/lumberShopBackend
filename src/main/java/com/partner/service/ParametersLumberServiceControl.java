package com.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.CategoryLumberRepository;
import com.partner.dataCrudInterfaces.ParametersLumberRepository;
import com.partner.dataObjects.CategoryLumber;
import com.partner.dataObjects.ParametersLumber;

@Service
public class ParametersLumberServiceControl {
	@Autowired
	private ParametersLumberRepository parametersLumberRepository;
	
	@Autowired
	private CategoryLumberRepository categoryLumberRepository;
	
	protected ParametersLumberServiceControl() {

	}
	
	public void saveParametersLumber(ParametersLumber parametersLumber) {
		parametersLumberRepository.save(parametersLumber);
	}
	
	public ParametersLumber getParametersLumberById (int id) {
		return parametersLumberRepository.findById(id).get();
	}
	 
	public List<ParametersLumber> getAllParametersLumbers (){
		List<ParametersLumber> listParametersLumber = new ArrayList<>();
		parametersLumberRepository.findAll().iterator().forEachRemaining(listParametersLumber::add);
		return listParametersLumber;
	}
	
	public List<CategoryLumber> getAllCategoriesLumbers (){
		List<CategoryLumber> listategoriesLumbers = new ArrayList<>();
		categoryLumberRepository.findAll().iterator().forEachRemaining(listategoriesLumbers::add);
		return listategoriesLumbers;
	}

}
