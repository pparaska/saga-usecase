package com.cg.saga.common.order;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.cg.saga.common.domain.Money;

public class OrderCreatedEvent implements OrderEvent {
	private Money orderTotal;
	private String customerId;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public OrderCreatedEvent() {
	}

	public OrderCreatedEvent(String customerId, Money orderTotal) {
		this.customerId = customerId;
		this.orderTotal = orderTotal;
	}

	public Money getOrderTotal() {
		return orderTotal;
	}

	public String getCustomerId() {
		return customerId;
	}
}
