package TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Test(groups = "all")
public class groups {
	@Test(groups = "smoke")
	public void TestMethod1() {
		System.out.println("This is TestMethod1");
	}
	@Test(groups = {"sanity","functional"})
	public void TestMethod2() {
		System.out.println("This is TestMethod2");
	}
	@Test(groups = {"regression","smoke"})
	public void TestMethod3() {
		System.out.println("This is TestMethod3");
	}
	@Test(groups = {"functional","sanity","smoke","regression"})
	public void TestMethod4() {
		System.out.println("This is TestMethod4");
	}
	@Test(groups = {"functional","regression"})
	public void TestMethod5() {
		System.out.println("This is TestMethod5");
	}
	@Test
	public void TestMethod6() {
		System.out.println("This is TestMethod6");
	}








}
