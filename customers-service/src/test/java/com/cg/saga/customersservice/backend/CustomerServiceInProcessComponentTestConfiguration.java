package com.cg.saga.customersservice.backend;

import io.eventuate.javaclient.spring.jdbc.EmbeddedTestAggregateStoreConfiguration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cg.saga.customersservice.web.CustomerWebConfiguration;

@Configuration
@Import({ CustomerWebConfiguration.class, EmbeddedTestAggregateStoreConfiguration.class })
@EnableAutoConfiguration
public class CustomerServiceInProcessComponentTestConfiguration {

}
