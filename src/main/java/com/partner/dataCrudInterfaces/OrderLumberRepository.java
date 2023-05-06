package com.partner.dataCrudInterfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.OrderLumber;

@Repository
public interface OrderLumberRepository extends CrudRepository<OrderLumber, Integer> {

}
