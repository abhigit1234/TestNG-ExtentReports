package TestNG_Practice;

import org.testng.annotations.Test;

public class TestClass1 {

	@Test
	public void TestMethod1() {
		System.out.println("TestClass1 ---Method1---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod2() {
		System.out.println("TestClass1 ---Method2---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod3() {
		System.out.println("TestClass1 ---Method3---"+Thread.currentThread().getId());
	}
}
