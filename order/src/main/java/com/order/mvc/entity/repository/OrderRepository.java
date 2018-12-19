package com.order.mvc.entity.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.order.mvc.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
