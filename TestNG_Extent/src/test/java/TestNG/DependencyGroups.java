package TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyGroups {
	@Test(groups = "regression")
	public void Test1() {
		System.out.println("regression");

	}

	@Test(groups = "functional")
	public void Test2() {
		System.out.println("functional");

	}

	@Test(groups = "sanity")
	public void Test3() {
		System.out.println("sanity");

	}

	@Test(groups = "regression")
	public void Test4() {
		System.out.println("regression");
	}

	@Test(groups = "sanity")
	public void Test5() {
		System.out.println("sanity");

	}

	@Test(groups = "smoke")
	public void Test6() {
		System.out.println("smoke");

	}

	@Test(groups = "smoke")
	public void Test7() {
		System.out.println(9/0);

	}
	@Test(groups = "functional")
	public void Test8() {
		System.out.println("functional");
	}

	//	@Test(dependsOnGroups = {"smoke","sanity","regression","functional"})
//	public void Test0() {
//		System.out.println("main");
//
//	}

}
