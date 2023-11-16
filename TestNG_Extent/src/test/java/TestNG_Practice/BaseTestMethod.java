package TestNG_Practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BaseTestMethod extends BaseTest {

	@Parameters("url")
	@Test
	public void url(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(5000);
	}
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
	

	}
	@Test(testName = "ProfileName")
	public void verifyProfileName() {
		System.out.println(driver.getTitle());
	String actual =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).getText();
	String expected = "Paul babu";
	assertEquals(actual, expected);
	}

}
