
package TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

                                                    //@Ignore at class level
public class Ignoring {
													//	@Ignore ( or )    at method level                                  
	@Test                                           //(enabled = false )
	public void Test1() {
		System.out.println("Test1");
	}

	@Test
	public void Test2() {
		System.out.println("Test2");
	}
	@Test
	public void Test3() {
		System.out.println("Test3");
	}
	@Test
	public void Test4() {
		System.out.println("Test4");
	}







}
