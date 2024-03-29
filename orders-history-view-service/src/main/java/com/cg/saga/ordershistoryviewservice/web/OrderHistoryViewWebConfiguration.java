package com.cg.saga.ordershistoryviewservice.web;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.cg.saga.ordershistoryviewservice.backend.OrderHistoryViewBackendConfiguration;

@Configuration
@ComponentScan
@Import(OrderHistoryViewBackendConfiguration.class)
public class OrderHistoryViewWebConfiguration {

	@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = new MappingJackson2HttpMessageConverter();
		return new HttpMessageConverters(additional);
	}

}
