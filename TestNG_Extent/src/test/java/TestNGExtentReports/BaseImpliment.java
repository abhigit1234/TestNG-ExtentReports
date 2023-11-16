package TestNGExtentReports;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseImpliment extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		capture(result.getTestContext().getName()+"_"+ result.getMethod().getMethodName()+".png");
	
	}

	
}
