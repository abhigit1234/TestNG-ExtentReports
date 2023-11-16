package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationWith3TestMethods {
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
	public void Test4() {
		System.out.println("This is Test4");
	}

	@Test
	public void Test5() {
		System.out.println("This is Test5");
	}

	@Test
	public void Test6() {
		System.out.println("This is Test6");
	}

}

	
