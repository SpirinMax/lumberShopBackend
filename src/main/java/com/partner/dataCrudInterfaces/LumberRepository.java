package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.Lumber;

@Repository
public interface LumberRepository extends CrudRepository<Lumber, Integer> {
	
}
