package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationAllMethods {
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("This will execute beforesuit");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("This will execute aftersuit");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This will execute beforeTest");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("This will execute afterTest");
	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This will execute beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will execute afterClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this will execute beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This will execute afterMethod");
	}

	@Test
	public void Test1() {
		System.out.println("This is Test1");
	}

	@Test
	public void Test2() {
		System.out.println("This is Test2");
	}

	@Test
	public void Test3() {
		System.out.println("This is Test3");
	}

}