package com.cg.saga.common.customer;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.cg.saga.customersservice.backend.Customer")
public interface CustomerEvent extends Event {
}
