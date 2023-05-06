package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.CategoryPrice;

@Repository
public interface CategoryPriceRepository extends CrudRepository<CategoryPrice, Integer> {
	
}
