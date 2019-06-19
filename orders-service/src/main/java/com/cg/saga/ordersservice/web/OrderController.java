package com.cg.saga.ordersservice.web;

import io.eventuate.EntityWithIdAndVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.saga.orderscommmon.CreateOrderRequest;
import com.cg.saga.orderscommmon.CreateOrderResponse;
import com.cg.saga.ordersservice.backend.CustomerNotFoundException;
import com.cg.saga.ordersservice.backend.Order;
import com.cg.saga.ordersservice.backend.OrderService;

@RestController
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
		try {
			EntityWithIdAndVersion<Order> order = orderService.createOrder(createOrderRequest.getCustomerId(),
					createOrderRequest.getOrderTotal());
			return new ResponseEntity<>(new CreateOrderResponse(order.getEntityId()), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
