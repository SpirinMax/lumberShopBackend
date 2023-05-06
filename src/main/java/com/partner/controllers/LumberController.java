package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.Lumber;
import com.partner.dataObjects.ParametersLumber;
import com.partner.service.LumberServiceControl;
import com.partner.service.ParametersLumberServiceControl;

@RestController
public class LumberController {
	@Autowired
	private LumberServiceControl lumberServiceControl;

	@Autowired
	private ParametersLumberServiceControl parametersLumberServiceControl;

	@GetMapping(value = "/restApi/lumber/parameters/getAll")
	public List<ParametersLumber> getAllParametersLumbers() {
		return parametersLumberServiceControl.getAllParametersLumbers();
	}

	@GetMapping(value = "/restApi/lumber/getById")
	public Lumber receiveLumberById(@RequestParam("id") int id) {
		return lumberServiceControl.getLuimberById(id);
	}

	@GetMapping(value = "/restApi/lumber/getAll")
	public List<Lumber> receiveAllLumbers(@RequestParam("p") int currentPage) {
		return lumberServiceControl.getAllLumbers(currentPage);
	}

}
