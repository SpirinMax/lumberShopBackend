package com.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partner.dataCrudInterfaces.OrderLumberRepository;
import com.partner.dataObjects.OrderLumber;

@Service
public class OrderLumberServiceControl {
	@Autowired
	private OrderLumberRepository orderLumberRepository;

	protected OrderLumberServiceControl() {

	}

	public void saveOrder(OrderLumber orderLumber) {
		orderLumberRepository.save(orderLumber);
	}

	public OrderLumber getOrderById(int id) {
		return orderLumberRepository.findById(id).get();
	}

	public List<OrderLumber> getAllOrder() {
		List<OrderLumber> listOrdersLumbers = new ArrayList<>();
		orderLumberRepository.findAll().iterator().forEachRemaining(listOrdersLumbers::add);
		return listOrdersLumbers;
	}
}
