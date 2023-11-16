package TestNG_Practice;

import org.testng.annotations.Test;

public class TestDependesOnGroups {

	@Test(groups = "smoke")
	public void test1() {
		System.out.println("smoke");
	}

	@Test(groups = "smoke")
	public void test2() {
		System.out.println("smoke");
	}

	@Test(groups = "functional")
	public void test3() {
		System.out.println("functional");
	}

	@Test(groups = "functional")
	public void test4() {
		System.out.println("functional");
	}

	@Test(groups = "regression")
	public void test5() {
		//System.out.println(2/0);
		System.out.println("regression");
}

	@Test(groups = "regression")
	public void test6() {
		System.out.println("regression");
	}

	@Test(groups = "sanity")
	public void test7() {
		System.out.println("sanity");
	}
	@Test(groups = "sanity")
	public void test8() {
		System.out.println("sanity");
	}
/*
	@Test(dependsOnGroups = {"smoke","regression"},alwaysRun = true)
	public void test0() {
		System.out.println("main");
	}
*/

}
