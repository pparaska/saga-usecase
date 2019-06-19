package com.cg.saga.views.orderhistory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cg.saga.ordershistoryviewservice.backend.OrderHistoryViewMongoConfiguration;

@Configuration
@EnableAutoConfiguration
@Import(OrderHistoryViewMongoConfiguration.class)
public class OrderHistoryViewServiceTestConfiguration {
}
