package com.cg.saga.common.customer;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.cg.saga.common.domain.Money;

public class CustomerCreatedEvent implements CustomerEvent {
	private String name;
	private Money creditLimit;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	private CustomerCreatedEvent() {
	}

	public CustomerCreatedEvent(String name, Money creditLimit) {

		this.name = name;
		this.creditLimit = creditLimit;
	}

	public String getName() {
		return name;
	}

	public Money getCreditLimit() {
		return creditLimit;
	}
}
