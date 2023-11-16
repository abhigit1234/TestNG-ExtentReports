package TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScreenshotMethod extends BaseTest {

	@Test(testName = "google")
	public void google() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("independence day", Keys.ENTER);
		System.out.println(driver.getTitle());
	}

	@Test(testName ="applitools" )
	public void applitools() throws InterruptedException {
		
		driver.get("https://demo.applitools.com/");
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("abhilashnaidu123");
		driver.findElement(By.id("password")).sendKeys("indian9988");
		driver.findElement(By.id("log-in")).click();
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//*[@id=\"time\"]")).getText();
		String expected = "Your nearest branch closes in: 40m 5s";
		assertEquals(actual, expected, "expected is not equal to actual");
		
		
	}
}
