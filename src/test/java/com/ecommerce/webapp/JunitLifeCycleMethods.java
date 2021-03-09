package com.ecommerce.webapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitLifeCycleMethods {

	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("--- Before All Test ---");
	}

	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("--- After All Test ---");
	}

	@BeforeEach
	void setUp() {
		System.out.println("--- Before Each Test ---");
	}

	@AfterEach
	void tearDown()  {
		System.out.println("--- After Each Test ---");
	}

	@Test
	void testOne() {
		System.out.println("--- Test 1 is Executed !---");
	}
	
	@Test
	void testTwo() {
		System.out.println("--- Test 2 is Executed !---");
	}
	
	@Test
	void testThree() {
		System.out.println("--- Test 3 is Executed !---");
	}

}
