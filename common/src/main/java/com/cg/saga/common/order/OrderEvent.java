package com.cg.saga.common.order;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.cg.saga.ordersservice.backend.Order")
public interface OrderEvent extends Event {
}
