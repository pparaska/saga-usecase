package com.cg.saga.common.domain;

import org.junit.Test;
import com.cg.saga.common.domain.Money;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyTest {

	private Money money1 = new Money(10);
	private Money money2 = new Money(15);

	@Test
	public void shouldReturnAmount() {
		assertEquals(new BigDecimal(10), new Money(10).getAmount());
	}

	@Test
	public void shouldCompare() {
		assertTrue(money2.isGreaterThanOrEqual(money1));
	}

	@Test
	public void shouldAdd() {
		assertEquals(new Money(25), money1.add(money2));
	}

	@Test
	public void shouldSubtract() {
		assertEquals(new Money(5), money2.subtract(money1));
	}

}