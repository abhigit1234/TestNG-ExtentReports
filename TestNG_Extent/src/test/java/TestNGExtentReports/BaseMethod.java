package TestNGExtentReports;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseMethod extends BaseTest {

	@Parameters("url")
	@Test(testName = "orangeHRM", groups = {"smoke"})
	public void login(String url) throws InterruptedException {
		driver.get(url);
		extentTest.info("Navigated to url");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		extentTest.info("Entered home page");
		Thread.sleep(3000);
		String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).getText();
		String exp = "abhilash";
		assertEquals(actual, exp);
		extentTest.info("failed due to assertion");
	}
}
