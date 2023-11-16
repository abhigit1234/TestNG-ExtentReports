package TestNG_Practice;

import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

	@Test
	public void login() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//	
		
		Date date = new Date();
	System.out.println(	date);
	
	}

}
