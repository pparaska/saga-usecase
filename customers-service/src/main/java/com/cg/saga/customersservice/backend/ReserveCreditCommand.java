package com.cg.saga.customersservice.backend;

import com.cg.saga.common.domain.Money;

public class ReserveCreditCommand implements CustomerCommand {
	private final Money orderTotal;
	private final String orderId;

	public ReserveCreditCommand(Money orderTotal, String orderId) {
		this.orderTotal = orderTotal;
		this.orderId = orderId;
	}

	public Money getOrderTotal() {
		return orderTotal;
	}

	public String getOrderId() {
		return orderId;
	}
}
