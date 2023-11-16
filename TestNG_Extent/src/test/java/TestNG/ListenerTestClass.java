package TestNG;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Image;
 //@Listeners({ITListener_Implements.class}) //while using xml we need to remove from class path
public class ListenerTestClass{
	@Test
	public void TestMethod1() {
		System.out.println("TestMethod 1");
	}
	
	@Test
	public void TestMethod2() {
		assertTrue(false);
		System.out.println("TestMethod 2");
	}
	@Test
	public void TestMethod3() {
		System.out.println("TestMethod 3");
	}
	@Test(timeOut = 1000)
	public void TestMethod4() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("TestMethod 4");
	}
}