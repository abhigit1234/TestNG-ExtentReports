package TestNG_Practice;

import org.testng.annotations.Test;

public class TestClass2 {

	@Test
	public void TestMethod4() {
		System.out.println("TestClass2 ---Method4---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod5() {
		System.out.println("TestClass2 ---Method5---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod6() {
		System.out.println("TestClass2 ---Method6---"+Thread.currentThread().getId());
	}
}
