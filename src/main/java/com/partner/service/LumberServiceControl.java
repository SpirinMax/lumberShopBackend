package com.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.LumberPagingRepository;
import com.partner.dataCrudInterfaces.LumberRepository;
import com.partner.dataObjects.Lumber;

@Service
public class LumberServiceControl {
	@Autowired
	private LumberRepository lumberRepository;
	@Autowired
	private LumberPagingRepository pagingRepository;

	protected LumberServiceControl() {

	}

	public void saveLumber(Lumber lumber) {
		lumberRepository.save(lumber);
	}

	public Lumber getLumberById(int id) {
		return lumberRepository.findById(id).get();
	}

	public List<Lumber> getAllLumbers(int currentPage) {
		List<Lumber> listLumbers = new ArrayList<>();
		Pageable pageable = PageRequest.of(currentPage, 5);
		pagingRepository.findAll(pageable).iterator().forEachRemaining(listLumbers::add);
		return listLumbers;
	}

	public List<Lumber> getLumbersByPrice(float price, int currentPage) {
		List<Lumber> listLumbers = new ArrayList<>();
		return listLumbers;
	}

}
