package com.partner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partner.dataObjects.OrderLumber;
import com.partner.service.OrderLumberServiceControl;

@RestController
public class OrderLumberController {
	@Autowired
	private OrderLumberServiceControl orderLumberServiceControl;

	@GetMapping(value = "/restApi/order/getById")
	public OrderLumber receiveOrderById(@RequestParam("id") int id) {
		return orderLumberServiceControl.getOrderById(id);
	}

	@GetMapping(value = "/restApi/order/getAll")
	public List<OrderLumber> receiveAllOrders() {
		return orderLumberServiceControl.getAllOrder();
	}
}
