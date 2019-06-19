package com.cg.saga.customersservice.backend;

import com.cg.saga.common.domain.Money;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public interface CustomerService {

	EntityWithIdAndVersion<Customer> createCustomer(String name, Money creditLimit);

	EntityWithMetadata<Customer> findById(String customerId);
}
