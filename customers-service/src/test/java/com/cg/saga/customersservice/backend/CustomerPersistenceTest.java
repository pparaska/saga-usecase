package com.cg.saga.customersservice.backend;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.sync.AggregateRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.saga.common.domain.Money;
import com.cg.saga.customersservice.backend.CreateCustomerCommand;
import com.cg.saga.customersservice.backend.Customer;
import com.cg.saga.customersservice.backend.CustomerCommand;
import com.cg.saga.customersservice.backend.ReserveCreditCommand;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CustomerServiceInProcessComponentTestConfiguration.class,
        webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class CustomerPersistenceTest {

  @Autowired
  private AggregateRepository<Customer, CustomerCommand> aggregateRepository;

  @Test
  public void shouldCreateAndUpdateCustomer() {
    EntityWithIdAndVersion<Customer> customer = aggregateRepository.save(new CreateCustomerCommand("Poonam", new Money(1234)));

    aggregateRepository.update(customer.getEntityId(), new ReserveCreditCommand(new Money(11), "order-1"));
    aggregateRepository.update(customer.getEntityId(), new ReserveCreditCommand(new Money(11), "order-2"));
    aggregateRepository.update(customer.getEntityId(), new ReserveCreditCommand(new Money(11), "order-3"));

  }
}
