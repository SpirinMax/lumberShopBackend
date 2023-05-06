package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.PriceLumber;

@Repository
public interface PriceLumberRepository extends CrudRepository<PriceLumber, Integer> {
}
