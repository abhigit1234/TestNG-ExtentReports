package TestNG_Practice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({implenetlisteners.class})
public class listnerclass {

	@Test
	public void test1() {
		System.out.println("inside test1");
	}

	@Test
	public void test2() {
		assertTrue(false);
		System.out.println("inside test2");
	}

	@Test(timeOut = 10)
	public void test3() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("inside test3");
	}

	@Test(dependsOnMethods = "test3")
	public void test4() {
		System.out.println("inside test4");
	}
}
