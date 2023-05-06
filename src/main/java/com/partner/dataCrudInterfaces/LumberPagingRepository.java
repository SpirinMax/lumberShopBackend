package com.partner.dataCrudInterfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.partner.dataObjects.Lumber;

public interface LumberPagingRepository extends PagingAndSortingRepository<Lumber, Integer> {
	
}

//SELECT * FROM partnerdb.prices_lumbers, partnerdb.lumbers 
//where prices_lumbers.id_lumber=lumbers.id_lumber and price>600 and price <2000;