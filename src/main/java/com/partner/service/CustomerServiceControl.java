package com.partner.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.partner.dataCrudInterfaces.CustomerRepository;
import com.partner.dataObjects.Customer;

@Service
public class CustomerServiceControl {

	@Autowired
	private CustomerRepository customerRepository;
	
	protected CustomerServiceControl() {

	}
	
	public void saveCustomer (Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public Customer getCustomerByPhone(String phone) {
		List<Customer> customers = customerRepository.findByPhone(phone);
		if (customers.size()>0) {
			return customers.get(0);
		} else {
			Customer notFoundCustomer = new Customer();
			notFoundCustomer.setPhone("Unknown phone");
			return notFoundCustomer;
		}
	}
	
	public List<Customer> getAllCustomers (){
		List<Customer> listCustomers = new ArrayList<>();
		customerRepository.findAll().iterator().forEachRemaining(listCustomers::add);
		return listCustomers;
	}
}
