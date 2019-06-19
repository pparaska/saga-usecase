package com.cg.saga.customersservice.backend;

import java.util.HashMap;
import java.util.Map;

import com.cg.saga.common.domain.Money;

public class ReservedCreditTracker {
	private Map<String, Money> creditReservations = new HashMap<>();

	Money reservedCredit() {
		return creditReservations.values().stream().reduce(Money.ZERO, Money::add);
	}

	void addReservation(String orderId, Money orderTotal) {
		creditReservations.put(orderId, orderTotal);
	}
}