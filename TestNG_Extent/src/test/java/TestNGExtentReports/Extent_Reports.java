package TestNGExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reports implements ITestListener {

	public ExtentTest extentTest;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public String timeStamp;

	@Override
	public void onStart(ITestContext context) {
		timeStamp = new SimpleDateFormat("ddMMMyyyy hhMMss").format(new Date());
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Reports//" + timeStamp + ".html");
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("Automation Testing");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("dd/MMM/yyyy HH:mm:ss:SS");
		spark.config().setReportName("OpenCart");
		extent.setSystemInfo("os name",	System.getProperty("os.name"));
		extent.setSystemInfo("os version",	System.getProperty("os.version"));
		extent.setSystemInfo("java version",System.getProperty("java.version"));
		extent.setSystemInfo("user name",System.getProperty("user.name"));
		extent.setSystemInfo("user country",System.getProperty("user.country"));
		
		if(!context.getCurrentXmlTest().getIncludedGroups().isEmpty()) {
			extent.setSystemInfo("groups", context.getCurrentXmlTest().getIncludedGroups().toString());
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest = extent.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.PASS, result.getName()+" got executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest =	extent.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		//extentTest.addScreenCaptureFromPath(new BaseClass().capture(result.getName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest =	extent.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP, result.getThrowable().getMessage());
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File("Reports//" + timeStamp + ".html").toURI());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}