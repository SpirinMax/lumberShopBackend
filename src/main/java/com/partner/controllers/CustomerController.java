package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.Customer;
import com.partner.service.CustomerServiceControl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceControl customerServiceControl;
	
	@GetMapping(value = "/restApi/customer")
	public Customer receiveCustomerById (@RequestParam("id") int id) {
		return customerServiceControl.getCustomerById(id);
	}
	
	@GetMapping(value = "/restApi/customerPhone")
	public Customer receiveCustomerByPhone (@RequestParam("phone") String phone) {		
		return customerServiceControl.getCustomerByPhone(phone);
	}
	
	@GetMapping(value = "/restApi/allCustomers")
	public List<Customer> receiveAllCustomers (){
		return customerServiceControl.getAllCustomers();
	}
	
}
