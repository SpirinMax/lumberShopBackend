package com.partner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.CustomerLoginRepository;
import com.partner.dataCrudInterfaces.CustomerRepository;
import com.partner.dataObjects.Customer;
import com.partner.dataObjects.CustomerLogin;

@Service
public class CustomerServiceControl {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerLoginRepository customerLoginRepository;
	
	protected CustomerServiceControl() {

	}
	
	public void saveLoginCustomer (CustomerLogin customerLogin) {
		customerLoginRepository.save(customerLogin);
	}
	
	public Customer saveCustomer (Customer customer) {
		return customerRepository.save(customer);
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
	
	public Optional<Customer> authCustomer (CustomerLogin login) {
		Optional<CustomerLogin> foundedCustomer = customerLoginRepository.findByLoginAndPassword(login.getLogin(),login.getPassword());
		if (foundedCustomer.isPresent()) {
			return customerRepository.findById(foundedCustomer.get().getIdCustomer());
		} else {
			return Optional.empty();
		}
	}
}
