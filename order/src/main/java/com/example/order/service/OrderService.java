package com.example.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.dto.ProductDto;
import com.example.order.modal.Order;
import com.example.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String product_url = "http://localhost:8080/api/products/";
	
	public Order placeOrder(Order order) {
		List<Long> productIds = order.getProductIds();
		List<ProductDto> products = new ArrayList<ProductDto>();
		if(!productIds.isEmpty()) {
			for(Long productId : productIds) {
				ProductDto productDto = restTemplate.getForObject(product_url + productId, ProductDto.class);
				products.add(productDto);
			}
		}
		if(!products.isEmpty()) {
			return orderRepository.save(order);			
		} else {
			return null;
		}
		
	}

}
