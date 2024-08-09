package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Partially_UsingIndices {
	// =====================Indices Method(selecting perticular array)=====JAGGED ARRAY(parameters can be any count)

	@Test(dataProvider = "loginpage")
	public void LoginPage(Object[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);		
		} 
		System.out.println("=====");
	
	}

	@DataProvider(indices = {0,2})
	public Object[][] loginpage() {
		Object[][] data = new Object[][] { { "harshini" , 758, "Hyderabad" ,"India",500047}, { "abhilash", 123, "malkajgiri" },{ "london" ,"ayansh","hasanth","sushma" }};

		return data;

	}
}
