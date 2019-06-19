package com.cg.saga.ordersservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cg.saga.commonswagger.CommonSwaggerConfiguration;
import com.cg.saga.ordersservice.web.OrderWebConfiguration;

@Configuration
@Import({ OrderWebConfiguration.class, EventuateDriverConfiguration.class, CommonSwaggerConfiguration.class })
@EnableAutoConfiguration
@ComponentScan
public class OrdersServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(OrdersServiceMain.class, args);
	}
}
