package TestNG_Practice;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static String screen;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		switch (browser.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("invalid browser");
			break;
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	
	@Test
	public void screenshot(String filename) {
				if(screen == null) {
		LocalDateTime ldt = LocalDateTime.now();
	DateTimeFormatter dtf =	DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
	screen = 	ldt.format(dtf);
		}
		TakesScreenshot tss = (TakesScreenshot) driver;
		File sourcefile = tss.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File("./screenshot/"+screen+"/"+filename);
		try {
			FileUtils.copyFile(sourcefile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screen shot saved successfully");
	}

}
