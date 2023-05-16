package com.shivam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// Note we can also create Just one Instance of the MathUtilsTest class instead of creating new
//Instance everytime during execution of each @Test method( which is a default ) by using @TestInstance annotation
// 

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

	MathUtils mu;
	
	@BeforeAll
	static void beforeAllMethod() {
		
		System.out.println("This method runs before any methods is run i.e even before the class MathUtilsTest is initialised by Junit Framework engine hence it is declared as static method ");
	}
	

	@BeforeEach
	void init() {
		mu = new MathUtils();

	}
	
	@AfterEach
	void cleanUp() {
		
		System.out.println("This method runs after each @Test menthod has run ");
	}

	@Test
	@DisplayName("Disabled Method ")
	@Disabled
	void test() {

		System.out.println("This test ran ");
	}

	@Test
	void test1() {

		int expected = 5;
		int actual = mu.add(2, 3);

		assertEquals(expected, actual, "The add of 2 numbers");

	}

	@Test
	@DisplayName("Circle Area ")
	void calculateCircleArea() {

		assertEquals(314.1592653589793, mu.calculateCircleArea(10), "Calculate Area of Circle ");
	}

	@Test
	void testDvide() {

		assertThrows(ArithmeticException.class, () -> mu.divide(3, 0), "Divide method exception ");
	}
	
	@Test
	@Disabled
	@DisplayName("Fail Method")
	void test2() {
		
		fail(" This is to test the fail method, this will fail everytime no matter what  ");
	}
	
	@AfterAll
	static void afterAllMethod() {
		System.out.println("This method runs after all the methods is run, this method also declared as static because the Instance of MathUtilsTest gets terminated at the last in the life cycle of Test by Junit ");
	}
}
