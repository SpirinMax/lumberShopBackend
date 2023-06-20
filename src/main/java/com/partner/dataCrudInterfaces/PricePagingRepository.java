package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.partner.dataObjects.PriceLumber;

public interface PricePagingRepository extends PagingAndSortingRepository<PriceLumber, Integer> {
	
}
