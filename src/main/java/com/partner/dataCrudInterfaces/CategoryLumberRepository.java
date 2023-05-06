package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.CategoryLumber;

@Repository
public interface CategoryLumberRepository extends CrudRepository<CategoryLumber, Integer> {

}
