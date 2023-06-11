package com.partner.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.Customer;
import com.partner.dataObjects.CustomerLogin;
import com.partner.service.CustomerServiceControl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceControl customerServiceControl;

	@Transactional
	@PostMapping(value = "/restApi/customer/create")
	public ResponseEntity<?> createNewCustomer(@RequestBody Customer customer, @RequestParam("login") String login,
			@RequestParam("password") String password) {
		try {
			Customer creatingCustomer = customerServiceControl.saveCustomer(customer);
			int id = creatingCustomer.getIdCustomer();
			CustomerLogin creatingLoginCustomer = new CustomerLogin();
			creatingLoginCustomer.setIdCustomer(id);
			creatingLoginCustomer.setLogin(login);
			creatingLoginCustomer.setPassword(password);
			customerServiceControl.saveLoginCustomer(creatingLoginCustomer);
			System.out.println("Customer: @id=" + customer.getIdCustomer() + " saved!");
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.OK.value(), "Customer successfully created"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server Error"),
					HttpStatus.OK);
		}
	}

	@PostMapping(value = "/restApi/customer/upd")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		try {
			String phone = customer.getPhone();
			Customer updCustomer = customerServiceControl.getCustomerByPhone(phone);
			Optional<String> fio = Optional.ofNullable(customer.getFIO());
			Optional<String> phoneStr = Optional.ofNullable(customer.getPhone());
			Optional<String> address = Optional.ofNullable(customer.getAddress());
			Optional<String> addressLegal = Optional.ofNullable(customer.getAddressCompany());
			Optional<String> nameCompany = Optional.ofNullable(customer.getNameCompany());
			if (customer.getIdCustomer() != 0)
				updCustomer.setIdCustomer(customer.getIdCustomer());
			if (fio.isPresent())
				updCustomer.setFIO(fio.get());
			if (phoneStr.isPresent())
				updCustomer.setPhone(phoneStr.get());
			if (address.isPresent())
				updCustomer.setAddress(address.get());
			if (addressLegal.isPresent())
				updCustomer.setAddressCompany(addressLegal.get());
			if (nameCompany.isPresent())
				updCustomer.setNameCompany(nameCompany.get());
			customerServiceControl.saveCustomer(updCustomer);
			System.out.println("Customer: @id=" + updCustomer.getIdCustomer() + " updated!");
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.OK.value(), "Customer successfully updated"),
					HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server Error"),
					HttpStatus.OK);
		}
	}

	@PostMapping(value = "/restApi/customer/auth")
	public ResponseEntity<?> getCustomerByLoginAndPassword(@RequestBody CustomerLogin customerLogin) {
		Optional<Customer> customer = customerServiceControl.authCustomer(customerLogin);
		if (customer.isPresent()) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping(value = "/restApi/customer")
	public Customer receiveCustomerById(@RequestParam("id") int id) {
		return customerServiceControl.getCustomerById(id);
	}

	@GetMapping(value = "/restApi/customerPhone")
	public Customer receiveCustomerByPhone(@RequestParam("phone") String phone) {
		return customerServiceControl.getCustomerByPhone(phone);
	}

	@GetMapping(value = "/restApi/allCustomers")
	public List<Customer> receiveAllCustomers() {
		return customerServiceControl.getAllCustomers();
	}

}
