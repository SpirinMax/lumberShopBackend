package com.partner.dataCrudInterfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.partner.dataObjects.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByPhone(String phone);
}
