package TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyOnMethods {
String trackingnum;
@Ignore
	@Test()
	public void createShipment() {
		//System.out.println(1/0);
		System.out.println("createShipment");
		trackingnum = "Zl288HP49ML";
	}

	@Test(dependsOnMethods  = { "createShipment"},ignoreMissingDependencies = true)
	public void trackShipment() throws Exception {
		if(trackingnum !=null) {
			System.out.println("trackShipment");
		
			}
		else {
			throw new Exception("invalid tracking number");
	}
		
	}
	@Test(dependsOnMethods = {"trackShipment","createShipment"},ignoreMissingDependencies = true)
	public void cancelShipment() throws Exception {
		if(trackingnum !=null) {
		System.out.println("cancelShipment");
	}
		else {
			throw new Exception("invalid tracking can't cancel");
		}
		}
}
