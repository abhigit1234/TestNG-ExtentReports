package TestNG_Practice;

import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class BaseImpliment extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		screenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
	}

	
	
	
	
}
