package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSeperateTestMethodClass {
	@Test(dataProvider = "login",dataProviderClass = DataProviderSeperateClass.class)
	public void TestMethod(Object[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + ":" + a[i]);
		}
		System.out.println();
	}

}
