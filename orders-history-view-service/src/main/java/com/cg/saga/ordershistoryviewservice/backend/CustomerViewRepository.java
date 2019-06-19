package com.cg.saga.ordershistoryviewservice.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.saga.ordershistorycommon.CustomerView;

public interface CustomerViewRepository extends MongoRepository<CustomerView, String>, CustomerViewRepositoryCustom {
}
