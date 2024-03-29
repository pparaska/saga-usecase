package com.cg.saga.customersservice.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.saga.common.domain.Money;
import com.cg.saga.customerscommon.CreateCustomerRequest;

import static com.jayway.restassured.RestAssured.given;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceInProcessComponentTestConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceInProcessComponentTest {

	@Value("${local.server.port}")
	private int port;

	private String baseUrl(String path) {
		return "http://localhost:" + port + path;
	}

	@Test
	public void shouldCreateOrder() {
		String postUrl = baseUrl("/customers");

		String customerId = given().body(new CreateCustomerRequest("Poonam Paraskar", new Money(1234)))
				.contentType("application/json").when().post(postUrl).then().statusCode(200).extract()
				.path("customerId");

		assertNotNull(customerId);

		Integer creditLimit = given().when().get(postUrl + "/" + customerId).then().statusCode(200).extract()
				.path("creditLimit.amount");

		assertEquals(new Integer(1234), creditLimit);

	}
}
