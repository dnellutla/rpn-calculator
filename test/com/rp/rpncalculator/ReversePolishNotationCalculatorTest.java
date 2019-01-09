package com.rp.rpncalculator;

import static com.rp.rpncalculator.ReversePolishNotationCalculator.calculate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Stack;

import org.junit.Test;

public class ReversePolishNotationCalculatorTest {
    @Test
    public void test_addition() {
        Stack<BigDecimal> numbers = new Stack<>();
        numbers.push(BigDecimal.TEN);
        numbers.push(BigDecimal.ONE);
        Stack<BigDecimal> actual = calculate(numbers, (num1, num2) -> num2.add(num1));
        assertThat(actual.pop(), is(new BigDecimal(11)));

    }

    @Test
    public void test_Subtraction() {
        Stack<BigDecimal> numbers = new Stack<>();
        numbers.push(BigDecimal.TEN);
        numbers.push(BigDecimal.ONE);
        Stack<BigDecimal> actual = calculate(numbers, (num1, num2) -> num2.subtract(num1));
        assertThat(actual.pop(), is(new BigDecimal(9)));

    }

    @Test
    public void test_Multiplication() {
        Stack<BigDecimal> numbers = new Stack<>();
        numbers.push(BigDecimal.TEN);
        numbers.push(BigDecimal.ONE);
        Stack<BigDecimal> actual = calculate(numbers, (num1, num2) -> num2.multiply(num1));
        assertThat(actual.pop(), is(new BigDecimal(10)));

    }

    @Test
    public void test_Division() {
        Stack<BigDecimal> numbers = new Stack<>();
        numbers.push(BigDecimal.TEN);
        numbers.push(BigDecimal.ONE);
        Stack<BigDecimal> actual = calculate(numbers, (num1, num2) -> num2.divide(num1));
        assertThat(actual.pop(), is(new BigDecimal(10)));
    }

}
