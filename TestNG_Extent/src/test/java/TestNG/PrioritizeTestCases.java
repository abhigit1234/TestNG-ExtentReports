package TestNG;

import org.testng.annotations.Test;

public class PrioritizeTestCases {
	@Test(priority=1)
	public void launch() {
		System.out.println("launch");
	}

	@Test(priority=2)
	public void signin() {
		System.out.println("signin");
	}

	@Test(priority=3)
	public void logout() {
		System.out.println("logout");
	}

}