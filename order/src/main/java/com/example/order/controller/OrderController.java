package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.modal.Order;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Order addProduct(@RequestBody Order order) {
		return orderService.placeOrder(order);		
	}

}
