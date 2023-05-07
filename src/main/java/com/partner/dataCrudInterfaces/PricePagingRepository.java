package com.partner.dataCrudInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.partner.dataObjects.BreedWood;
import com.partner.dataObjects.CategoryLumber;
import com.partner.dataObjects.Lumber;
import com.partner.dataObjects.ParametersLumber;
import com.partner.dataObjects.PriceLumber;

public interface PricePagingRepository extends PagingAndSortingRepository<PriceLumber, Integer> {
	//Page<PriceLumber> findByLumberByParametersLumberByCategoryLumber(CategoryLumber categoryLumber, Pageable pageable);
//	Page<PriceLumber> findByLumber_ParametersLumber_CategoryLumberAndBreedWood 
//	(CategoryLumber categoryLumber, BreedWood breeedWood, Pageable pageable);
}
