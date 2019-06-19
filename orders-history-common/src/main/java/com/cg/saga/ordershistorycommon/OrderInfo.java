package com.cg.saga.ordershistorycommon;

import com.cg.saga.common.domain.Money;
import com.cg.saga.common.order.OrderState;

public class OrderInfo {

	private OrderState state;
	private String orderId;
	private Money orderTotal;

	public OrderInfo() {
	}

	public OrderInfo(String orderId, Money orderTotal) {
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.state = OrderState.CREATED;
	}

	public void approve() {
		state = OrderState.APPROVED;
	}

	public void reject() {
		state = OrderState.REJECTED;
	}

	public Money getOrderTotal() {
		return orderTotal;
	}

	public OrderState getState() {
		return state;
	}
}
