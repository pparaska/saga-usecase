package com.cg.saga.ordershistoryviewservice.backend;

import com.cg.saga.common.domain.Money;
import com.cg.saga.common.order.OrderState;

public interface OrderViewRepositoryCustom {
	void addOrder(String orderId, Money orderTotal);

	void updateOrderState(String orderId, OrderState state);
}
