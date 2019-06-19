package com.cg.saga.customersservice.backend;

import io.eventuate.Aggregates;
import io.eventuate.DefaultMissingApplyEventMethodStrategy;
import io.eventuate.Event;

import org.junit.Before;
import org.junit.Test;

import com.cg.saga.common.customer.CustomerCreatedEvent;
import com.cg.saga.common.customer.CustomerCreditLimitExceededEvent;
import com.cg.saga.common.customer.CustomerCreditReservedEvent;
import com.cg.saga.customersservice.backend.CreateCustomerCommand;
import com.cg.saga.customersservice.backend.Customer;
import com.cg.saga.customersservice.backend.CustomerCommand;
import com.cg.saga.customersservice.backend.ReserveCreditCommand;

import java.util.List;

import static io.eventuate.EventUtil.events;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

	private Customer customer;
	private List<Event> events;

	@Before
	public void createEmptyCustomer() {
		customer = new Customer();
	}

	@Test
	public void testCreate() {

		process(new CreateCustomerCommand(CustomerBaseClass.name, CustomerBaseClass.creditLimit));

		assertEventEquals(new CustomerCreatedEvent(CustomerBaseClass.name, CustomerBaseClass.creditLimit));

		applyEventsToMutableAggregate();

		assertEquals(CustomerBaseClass.creditLimit, customer.getCreditLimit());
		assertEquals(CustomerBaseClass.creditLimit, customer.availableCredit());
	}

	private void applyEventsToMutableAggregate() {
		Aggregates.applyEventsToMutableAggregate(customer, events, DefaultMissingApplyEventMethodStrategy.INSTANCE);
	}

	@Test
	public void testReserveCredit() {
		initializeCustomer();

		process(new ReserveCreditCommand(CustomerBaseClass.orderTotalWithinCreditLimit, CustomerBaseClass.orderId));

		assertEventEquals(new CustomerCreditReservedEvent(CustomerBaseClass.orderId,
				CustomerBaseClass.orderTotalWithinCreditLimit));

		applyEventsToMutableAggregate();

		assertEquals(CustomerBaseClass.creditLimit, customer.getCreditLimit());
		assertEquals(CustomerBaseClass.creditLimit.subtract(CustomerBaseClass.orderTotalWithinCreditLimit),
				customer.availableCredit());

	}

	@Test
	public void testCreditLimitExceeded() {
		initializeCustomer();

		process(new ReserveCreditCommand(CustomerBaseClass.orderTotalThatExceedsCreditLimit,
				CustomerBaseClass.orderId));

		assertEventEquals(new CustomerCreditLimitExceededEvent(CustomerBaseClass.orderId));

		applyEventsToMutableAggregate();

		assertEquals(CustomerBaseClass.creditLimit, customer.getCreditLimit());
		assertEquals(CustomerBaseClass.creditLimit, customer.availableCredit());
	}

	private <T extends CustomerCommand> void process(T command) {
		events = customer.processCommand(command);
	}

	private void assertEventEquals(Event expectedEvent) {
		assertEquals(events(expectedEvent), events);
	}

	private void initializeCustomer() {
		process(new CreateCustomerCommand(CustomerBaseClass.name, CustomerBaseClass.creditLimit));
		applyEventsToMutableAggregate();
	}

}