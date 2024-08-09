package TestNGExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static  ExtentTest extentTest;
	
	@Parameters("browserName")
	@BeforeTest
	public void Setup(ITestContext context, String browserName) {
		switch (browserName.toLowerCase()) {
		case "firefox":
		
			driver = new FirefoxDriver();
			break;

		case "chrome":
		
			driver = new ChromeDriver();
			break;
			
		case "edge":
		
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid Browser");
			break;
		}
		Capabilities cap =  ((RemoteWebDriver)driver).getCapabilities();
		String device = cap.getBrowserName()+" "+cap.getBrowserVersion().substring(0, cap.getBrowserVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getParameter("author");
		
		extentTest = extent.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
			
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@BeforeSuite
	public void initialiseExtent() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Reports.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("os name", System.getProperty("os.name"));
		extent.setSystemInfo("java version", System.getProperty("java.version"));
		
		
	}
	@AfterSuite
	public void generateReports() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("Reports.html").toURI());
	}
	@BeforeMethod
	public void group(Method m) {
		
		extentTest.assignCategory(m.getAnnotation(org.testng.annotations.Test.class).groups());
	}
	
	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String screenpath = null;
		screenpath =	capture(result.getTestContext().getName()+"_"+ result.getMethod().getMethodName()+".png");
		extentTest.addScreenCaptureFromPath(screenpath);
		extentTest.fail(result.getThrowable());
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.pass(m.getName() +"is passed");
		}
		
	}
	
	
	
	public String capture(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screensaver//"+filename);
	try {
		FileUtils.copyFile(source, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	System.out.println("screensaved successfully");
		return dest.getAbsolutePath();
		
	}
}
