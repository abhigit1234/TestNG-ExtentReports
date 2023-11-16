package TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
@Test(groups = "all")
public class Groups2 {

	@Test(groups = { "sanity", "smoke" })
	public void Test4() {
		System.out.println("Test4");
	}

	@Test(groups = { "functional", "regression", "smoke" })
	public void Test5() {
		System.out.println("Test5");
	}

	@Test(groups = { "smoke", "functional", "sanity" })
	public void Test6() {
		System.out.println("Test6");
	}

	@Test
	public void Test7() {
		System.out.println("Test7");
	}

}
