package TestNG_Practice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class timeout {

	@Test(expectedExceptions = {TimeoutException.class})
	public void time() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com");
		WebElement ele = driver.findElement(By.name("dd"));
		ele.click();
		
		WebDriverWait wait = new WebDriverWait((WebDriver) ele, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
		driver.close();

	}

}
