package com.cg.saga.ordershistorycommon;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cg.saga.common.domain.Money;
import com.cg.saga.common.order.OrderState;

@Document
public class OrderView {

	@Id
	private String id;

	private OrderState state;
	private Money orderTotal;

	public OrderView() {
	}

	public OrderView(String id, Money orderTotal) {
		this.id = id;
		this.orderTotal = orderTotal;
		this.state = OrderState.CREATED;
	}

	public Money getOrderTotal() {
		return orderTotal;
	}

	public OrderState getState() {
		return state;
	}
}
