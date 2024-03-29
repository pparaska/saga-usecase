package com.cg.saga.ordershistoryviewservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cg.saga.commonswagger.CommonSwaggerConfiguration;
import com.cg.saga.ordershistoryviewservice.web.OrderHistoryViewWebConfiguration;

@Configuration
@Import({ OrderHistoryViewWebConfiguration.class, EventuateDriverConfiguration.class,
		CommonSwaggerConfiguration.class })
@EnableAutoConfiguration
@ComponentScan
public class OrderHistoryQuerySideService {

	public static void main(String[] args) {
		SpringApplication.run(OrderHistoryQuerySideService.class, args);
	}
}
