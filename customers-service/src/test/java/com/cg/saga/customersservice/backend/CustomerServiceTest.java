package com.cg.saga.customersservice.backend;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.cg.saga.customersservice.backend.CreateCustomerCommand;
import com.cg.saga.customersservice.backend.Customer;
import com.cg.saga.customersservice.backend.CustomerCommand;
import com.cg.saga.customersservice.backend.CustomerService;
import com.cg.saga.customersservice.backend.CustomerServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

	private CustomerService customerService;
	private AggregateRepository<Customer, CustomerCommand> aggregateRepository;

	@Before
	public void setUp() {
		aggregateRepository = mock(AggregateRepository.class);
		customerService = new CustomerServiceImpl(aggregateRepository);
	}

	@Test
	public void shouldCreateCustomer() {

		EntityWithIdAndVersion<Customer> returned = new EntityWithIdAndVersion<>(null, null);

		when(aggregateRepository.save(any(CreateCustomerCommand.class))).thenReturn(returned);

		EntityWithIdAndVersion<Customer> result = customerService.createCustomer(CustomerBaseClass.name,
				CustomerBaseClass.creditLimit);

		assertSame(returned, result);

		ArgumentCaptor<CreateCustomerCommand> argument = ArgumentCaptor.forClass(CreateCustomerCommand.class);

		verify(aggregateRepository).save(argument.capture());
		verifyNoMoreInteractions(aggregateRepository);

		CreateCustomerCommand command = argument.getValue();

		assertEquals(CustomerBaseClass.name, command.getName());
		assertEquals(CustomerBaseClass.creditLimit, command.getCreditLimit());

	}

}