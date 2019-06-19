package com.cg.saga.ordersservice.backend;

import com.cg.saga.common.domain.Money;

import io.eventuate.EntityWithIdAndVersion;

public interface OrderService {

	EntityWithIdAndVersion<Order> createOrder(String customerId, Money orderTotal);
}
