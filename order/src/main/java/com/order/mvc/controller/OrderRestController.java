package com.order.mvc.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.mvc.entity.OrderEntity;
import com.order.mvc.entity.service.OrderServiceImpl;
import com.order.mvc.exception.NotFoundException;

/**
 * @author Maksim
 * */
@RestController
@RequestMapping("/orders")
public class OrderRestController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;

	/**
	 * show orders list
	 */
	@GetMapping
	List<OrderEntity> allOrders() {
		return orderServiceImpl.findAll();
	}
	/**
	 * create new order
	 */
	@PostMapping
	OrderEntity newOrder(@Validated @RequestBody OrderEntity order) {
		order.setDate(new Timestamp(System.currentTimeMillis()));
		order.setTotalPrice(order.getUnitPrice()*order.getQuantity());
		return orderServiceImpl.save(order);
	}
	/**
	 * show order
	 */
	@GetMapping("/{id}")
	OrderEntity order(@PathVariable Long id) {
		Optional<OrderEntity> order = orderServiceImpl.findById(id);
			return order.orElseThrow(()->new NotFoundException());
		
	}
	/**
	 * edite order
	 */
	@PutMapping("/{id}")
	OrderEntity replaceOrder(@Validated @RequestBody OrderEntity newOrder, @PathVariable Long id) {
		Optional<OrderEntity> optional = orderServiceImpl.findById(id);
	
		if(!optional.isPresent()) {
			return optional.orElseThrow(()->new NotFoundException());
		}
		
		OrderEntity  order = optional.get();
		order.setQuantity(newOrder.getQuantity());
		order.setDate(new Timestamp(System.currentTimeMillis()));
		order.setUnitPrice(newOrder.getUnitPrice());
		order.setTotalPrice(order.getUnitPrice()*order.getQuantity());
		order.setStatus(newOrder.getStatus());

		return orderServiceImpl.save(order);
	}

	@DeleteMapping("/{id}")
	void orderRemove(@PathVariable Long id) {
		orderServiceImpl.deleteById(id);
	}
}
