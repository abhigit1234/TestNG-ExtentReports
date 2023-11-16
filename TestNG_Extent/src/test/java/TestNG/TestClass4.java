package TestNG;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class TestClass4 {
		@Test
	public void TestMethod10() {
		System.out.println("TestClass4 -> TestMethod10 " + Thread.currentThread().getId());
	}
		@Test()
		public void TestMethod11() {
			System.out.println("TestClass4 -> TestMethod11 " + Thread.currentThread().getId());
		}
		@Test
		public void TestMethod12() {
			System.out.println("TestClass4 -> TestMethod12 " + Thread.currentThread().getId());
		}
		
}
