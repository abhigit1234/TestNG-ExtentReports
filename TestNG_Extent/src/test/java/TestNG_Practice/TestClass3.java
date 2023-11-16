package TestNG_Practice;

import org.testng.annotations.Test;

public class TestClass3 {

	@Test
	public void TestMethod7() {
		System.out.println("TestClass3 ---Method7---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod8() {
		System.out.println("TestClass3 ---Method8---"+Thread.currentThread().getId());
	}

	@Test
	public void TestMethod9() {
		System.out.println("TestClass3 ---Method9---"+Thread.currentThread().getId());
	}


	
}
