package com.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.BreedWoodRepository;
import com.partner.dataObjects.BreedWood;

@Service
public class BreedWoodServiceControl {
	@Autowired
	private BreedWoodRepository breedWoodRepository;

	protected BreedWoodServiceControl() {
		
	}
	
	public void saveBreedWood (BreedWood breedWood ) {
		breedWoodRepository.save(breedWood);
	}
	
	public BreedWood getBreedWoodById (int id) {
		return breedWoodRepository.findById(id).get();
	}
	
	public List<BreedWood> getAllBreedsWoods (){
		List<BreedWood> listBreedsWoods = new ArrayList<>();
		breedWoodRepository.findAll().iterator().forEachRemaining(listBreedsWoods::add);
		return listBreedsWoods;
	}
}
