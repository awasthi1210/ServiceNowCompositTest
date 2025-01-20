package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import com.snow.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeMethod
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		AssertJUnit.assertEquals(5, calculator.add(2, 3));
	}

	@Test
	public void testSubtract() {
		AssertJUnit.assertEquals(2, calculator.subtract(5, 3));
	}

	@Test
	public void testMultiply() {
		AssertJUnit.assertEquals(15, calculator.multiply(3, 5));
	}

	@Test
	public void testDivide() {
		AssertJUnit.assertEquals(2, calculator.divide(10, 5));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDivideByZero() {
		calculator.divide(10, 0);
	}

	// Add more test cases as needed
}
