package com.order.mvc.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.mvc.entity.OrderEntity;
import com.order.mvc.entity.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public OrderEntity save(OrderEntity orderEntity) {
		return orderRepository.save(orderEntity);
	}
	public List<OrderEntity> findAll(){
		return orderRepository.findAll();
	}
	public Optional<OrderEntity> findById(long id){
		return orderRepository.findById(id);
	}
	public void deleteById(long id){
		 orderRepository.deleteById(id);
		 
	}
}
