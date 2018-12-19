package com.order.mvc.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.order.mvc.order.status.Status;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false, unique = true)
	long id;
	private Timestamp date;
	@Min(value = 1, message = "must be greater than or equal to 1")
	@NotNull(message = "must be set")
	Integer quantity;
	@Min(value = 1, message = "must be greater than or equal to 1")
	@NotNull(message = "must be set")
	Float unitPrice;
	Float totalPrice;
	Status status;
}
