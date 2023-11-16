package TestNG;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions_soft_hard {
	@Test
	public void loginpage() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("hello",Keys.ENTER);
		
		SoftAssert softassert = new SoftAssert();
	
		
		// title assertion
		String actualtitle = driver.getTitle();
		String expectedtitle = "Log in to Facebook";
		assertEquals(actualtitle, expectedtitle,"title mis-match");
		
		//  url assertion
	
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://www.facebook.com/";
		softassert.assertNotEquals(actualurl, expectedurl,"url mis-match");
	
		
		// text assertion
		String actualtext = driver.findElement(By.name("email")).getAttribute("value");
		String expectedtext = "hello";
		assertEquals(actualtext, expectedtext,"text-mismatched");
		
		// error assertion
		String actualerror = driver.findElement(By.xpath("//div[@class=\"clearfix _5466 _44mg\"]//div[2]")).getText();
		String expectederror = "The password that you've entered is incorrect. Forgotten password?";
		assertEquals(actualerror, expectederror,"error-mismatched");
		
		//border assertion
		String actualborder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedborder = "1px solid rgb(240, 40, 73)";
		assertEquals(actualborder, expectedborder,"border-mismatched");
		
	Thread.sleep(2000);
	driver.close();
	softassert.assertAll();
	
	
	
	
	
	
	}

}
