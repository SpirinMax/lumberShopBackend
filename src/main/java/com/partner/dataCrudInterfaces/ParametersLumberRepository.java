package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.ParametersLumber;

@Repository
public interface ParametersLumberRepository extends CrudRepository<ParametersLumber, Integer>{

}
