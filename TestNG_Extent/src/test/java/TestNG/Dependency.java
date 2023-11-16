package TestNG;
//even if we set priority to test ,it first gives importance to dependency of testMethods
//priority is not required for dependency methods
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Dependency {

	static String trackingnumber = null;
	@Ignore
	@Test
	public void CreateShipment() {
		System.out.println(7/0);
		System.out.println("tracking shipment");
		trackingnumber = "ahdi3u2";

	}

	@Test(dependsOnMethods = { "CreateShipment" },ignoreMissingDependencies = true)
	public void TrackingShipment() throws Exception {
		if (trackingnumber != null)

			System.out.println("tracking shipment");
		else
			throw new Exception("invalid trackingnumber");

	}

	@Test(dependsOnMethods = { "CreateShipment", "TrackingShipment" },ignoreMissingDependencies = true)
	public void CancelShipment() throws Exception {
		if (trackingnumber != null)
			System.out.println("cancel shipment");
		else
			throw new Exception("invalid trackingnumber");

	}

}
