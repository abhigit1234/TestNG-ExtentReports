package TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderSeperateClass {
	
	
	@DataProvider(indices = {1,2})
	
	public Object[][] login() {
		Object[][] data  = new Object[][] {
				{"abhilash",998540050,"durgumahanthi"},
				{"hasanth",984913134,"durgumahanthi","London","UK","southhall"},
				{"Sushma",984653536,"Shetty","London","UK"},
				{"hash",832825074,"durgumahanthi","Boston"}
				};
				return data;
				
		

	
	}

}
