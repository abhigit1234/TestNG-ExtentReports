package TestNG;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.DateFormatter;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotsubfolder;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	public void screenshot(String fileName) {

		if(screenshotsubfolder==null) {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			screenshotsubfolder = 	ldt.format(dtf);
				
		}
		
		TakesScreenshot tss = (TakesScreenshot) driver;
		File sourfFile = tss.getScreenshotAs(OutputType.FILE);
		File destfFile = new File("./screenshot/"+screenshotsubfolder+"/"+fileName);
		try {
			FileUtils.copyFile(sourfFile, destfFile);
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		System.out.println("Screen shot saved successfully");
		
	}



}
