package com.cg.saga.customersservice.backend;

import com.cg.saga.common.domain.Money;

public class CustomerBaseClass {

  static Money creditLimit = new Money(56);
  static Money orderTotalThatExceedsCreditLimit = creditLimit.add(new Money(1));
  static String name = "Poonam";
  static String orderId = "myorder";
  static Money orderTotalWithinCreditLimit = new Money(5);
}
