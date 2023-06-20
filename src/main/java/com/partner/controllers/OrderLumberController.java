package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.bot.TelegramBot;
import com.partner.dataObjects.Customer;
import com.partner.dataObjects.OrderLumber;
import com.partner.service.CustomerServiceControl;
import com.partner.service.OrderLumberServiceControl;

@RestController
public class OrderLumberController {
	@Autowired
	private OrderLumberServiceControl orderLumberServiceControl;
	
	@Autowired
	private CustomerServiceControl customerServiceControl;

	@GetMapping(value = "/restApi/order/getById")
	public OrderLumber receiveOrderById(@RequestParam("id") int id) {
		return orderLumberServiceControl.getOrderById(id);
	}

	@GetMapping(value = "/restApi/order/getAll")
	public List<OrderLumber> receiveAllOrders() {
		return orderLumberServiceControl.getAllOrder();
	}
	@Transactional
	@PostMapping(value="restApi/order/create")
	public ResponseEntity<?> createOrder (@RequestBody OrderLumber order, @RequestParam("phone") String phone){
		try {
			Customer customer = customerServiceControl.getCustomerByPhone(phone);
			order.setIdCustomer(customer.getIdCustomer());
			OrderLumber savedOrder = orderLumberServiceControl.saveOrder(order);
			TelegramBot bot = new TelegramBot();
			bot.sendMessageAboutSuccessfulOrderCreation(customer, savedOrder);
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.OK.value(), "ORDER successfully created"),
					HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new HandlerHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server Error"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
