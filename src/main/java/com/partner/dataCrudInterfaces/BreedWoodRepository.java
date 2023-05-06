package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.BreedWood;

@Repository
public interface BreedWoodRepository extends CrudRepository<BreedWood, Integer> {

}
