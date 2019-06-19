package com.cg.saga.ordershistoryviewservice.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.saga.ordershistorycommon.OrderView;

public interface OrderViewRepository extends MongoRepository<OrderView, String>, OrderViewRepositoryCustom {
}
