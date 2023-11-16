package TestNGExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.google.gson.FieldAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.metrics.View;

public class fullextentdemo {
	public static WebDriver driver;

	@Test
	public void system() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark1 = new ExtentSparkReporter("AllReports.html");
		ExtentSparkReporter spark2 = new ExtentSparkReporter("pass.html");
		ExtentSparkReporter spark3 = new ExtentSparkReporter("fail.html");
		ExtentSparkReporter spark4 = new ExtentSparkReporter("skipped.html");
		ExtentSparkReporter spark5 = new ExtentSparkReporter("warning.html");
		ExtentSparkReporter spark = new ExtentSparkReporter("spark report.html");
		spark2.filter().statusFilter().as(new Status[] { Status.PASS }).apply();
		spark3.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();
		spark4.filter().statusFilter().as(new Status[] { Status.SKIP }).apply();
		spark5.filter().statusFilter().as(new Status[] { Status.WARNING }).apply();
		ExtentSparkReporterConfig sp = spark1.config();

		sp.setReportName("abhi");
		sp.setDocumentTitle("google page");
		sp.setTheme(Theme.DARK);

		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.AUTHOR,

		});

		extent.attachReporter(spark, spark1, spark2, spark3, spark4, spark5);

		extent.createTest("test1")
		.pass(MarkupHelper.createLabel("deepthi", ExtentColor.BLACK))
		.assignDevice("chrome")
		.assignCategory("smoke")
		.assignAuthor("ayaansh");
		
		extent.createTest("test2").
		fail("abhi")
		.assignDevice("firefox")
		.assignCategory("functional")
		.assignAuthor("hasanth");
		
		extent.createTest("test3")
		.skip("kumar")
		.assignDevice("edge")
		.assignCategory("regression")
		.assignAuthor("sushma");
		
		extent.createTest("test4")
		.warning("kumar")
		.assignDevice("edge")
		.assignCategory("regression")
		.assignAuthor("abhilash");

		Throwable t = new Throwable("exception thrown");
		extent.createTest("Test5")
		.fail(t);

		extent.setSystemInfo("os name", System.getProperty("os.name"));
		extent.setSystemInfo("os version", System.getProperty("os.version"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("java version", System.getProperty("java.version"));

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		extent.setSystemInfo("browsername",
				cap.getBrowserName() + "" + cap.getBrowserVersion().substring(0, cap.getBrowserVersion().indexOf(".")));

		extent.setSystemInfo("App url", driver.getCurrentUrl());
		
		String base64 = capture();
		extent.createTest("base64 screen shot")
		.fail("failed test")
		.addScreenCaptureFromBase64String(base64, "google url");
		
		
		
		extent.flush();
		driver.close();
		Desktop.getDesktop().browse(new File("spark report.html").toURI());
		Desktop.getDesktop().browse(new File("AllReports.html").toURI());
		Desktop.getDesktop().browse(new File("pass.html").toURI());
		Desktop.getDesktop().browse(new File("fail.html").toURI());
		Desktop.getDesktop().browse(new File("skipped.html").toURI());
		Desktop.getDesktop().browse(new File("warning.html").toURI());

	}

	
	public static String capture() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}
}
