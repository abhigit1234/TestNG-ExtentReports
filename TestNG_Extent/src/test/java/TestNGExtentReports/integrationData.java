package TestNGExtentReports;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class integrationData {

	@Test( dataProvider = "abhi",dataProviderClass = integrationExcel.class)
	public void launch(Object username,Object password) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys((CharSequence)username);
		driver.findElement(By.name("password")).sendKeys((CharSequence)password);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		String actual =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).getText();
		String exp = "Silk Smitha";
		assertEquals(actual, exp);

		driver.close();
		
	
	}
}
