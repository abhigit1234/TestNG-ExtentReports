package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvider {
//with dataprovider name
//	
//	@Test(dataProvider = "logindetails")
//	public void LoginPage(String username, String password) throws InterruptedException {
//

//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(3000);
//		driver.findElement(By.name("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//
//		Thread.sleep(5000);
//		driver.close();
//	}
//
//	@org.testng.annotations.DataProvider(name = "logindetails")
//	public Object[][] Login() {
//		Object[][] data = new Object[2][2];
//		data[0][0] = "Admin";
//		data[0][1] = "admin123";
//
//		data[1][0] = "usernameabhi";
//		data[1][1] = "999999999999";
//
//		return data;
//	}
//	
//	without data provider name

		@Test(dataProvider = "Login")
	public void LoginPage(String username, String password) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		Thread.sleep(5000);
		driver.close();
	}

	@org.testng.annotations.DataProvider()
	public Object[][] Login() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "usernameabhi";
		data[1][1] = "999999999999";

		return data;
	}
}
