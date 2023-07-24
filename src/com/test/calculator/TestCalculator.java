package com.test.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.example.calculator.Calculator;

public class TestCalculator {

	@Test
	public void testAdd() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testAdd2() throws Exception {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testAddMultipleNumbers() throws Exception {
		assertEquals(9, Calculator.add("2,3,4"));
	}
	
	@Test
	public void testNewLineNumbers() throws Exception {
		assertEquals(12, Calculator.add("3\n5,4"));
	}
	
	@Test
	public void testDiffDelimeters() throws Exception {
		assertEquals(4, Calculator.add("//;\n2;2"));
	}
	
	@Test
	public void testNegatives() throws Exception {
		assertEquals(0, Calculator.add("//;\n-1;-2"));
	}
	
	@Test
	public void greaterThan1000() throws Exception {
		assertEquals(2, Calculator.add("1001,2"));
	}
	
	@Test
	public void point7() throws Exception {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void multipleDelimeters() throws Exception {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void multipleDelimetersWithLengthLonger() throws Exception {
		assertEquals(6, Calculator.add("//[**][%%]\n1**2%%3"));
	}
}
