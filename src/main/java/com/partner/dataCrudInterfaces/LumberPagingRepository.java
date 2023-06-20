package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.partner.dataObjects.Lumber;

public interface LumberPagingRepository extends PagingAndSortingRepository<Lumber, Integer> {
	
}