package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.BreedWood;
import com.partner.service.BreedWoodServiceControl;

@RestController
public class BreedWoodController {

	@Autowired
	private BreedWoodServiceControl breedWoodServiceControl;
	
	@GetMapping(value = "/restApi/breedWood")
	public BreedWood receiveBreedWoodById (@RequestParam("id") int id) {
		return breedWoodServiceControl.getBreedWoodById(id);
	}
	
	@GetMapping(value = "/restApi/allBreedsWoods")
	public List<BreedWood> receiveAllBreedsWoods(){
		return breedWoodServiceControl.getAllBreedsWoods();
	}
}
