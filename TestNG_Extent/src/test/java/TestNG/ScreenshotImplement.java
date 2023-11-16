package TestNG;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotImplement extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		screenshot(result.getTestContext().getName()+"_"+ result.getMethod().getMethodName()+".jpg");
		System.out.println(result.getTestContext().getName()+"_"+ result.getMethod().getMethodName()+".jpg");
		
		
	}
	
}
