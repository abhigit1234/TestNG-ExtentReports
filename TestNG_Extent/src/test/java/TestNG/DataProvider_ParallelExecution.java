package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_ParallelExecution {
	@Test(dataProvider = "Login")
	public void LoginPage(String username, String password) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		Thread.sleep(5000);
		driver.close();
	}

	@DataProvider(parallel = true)
	public Object[][] Login() {
		Object[][] data = new Object[6][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "usernameabhi";
		data[1][1] = "hydhaleem";

		data[2][0] = "naidu2333";
		data[2][1] = "paradise423";

		data[3][0] = "babuabhi8797";
		data[3][1] = "googlenaidu21";

		data[4][0] = "Administration";
		data[4][1] = "adminking";

		data[5][0] = "iamabhi";
		data[5][1] = "retrunvalue";

		return data;
	}

}