package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetstoreTestMethod {
	WebDriver driver;
	@BeforeTest
	public void InitializeBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	@Test
	public void launch() {
		driver.get("https://petstore.octoperf.com/");
	}
	@Test
	public void enterStore() {
		driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
		System.out.println(driver.getTitle());
	}
	@Test
	public void verifyLogo() {
		System.out.println(driver.findElement(By.id("LogoContent")).getText());
	}
	@Test
	public void signIn() {
		driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]")).click();
	}
}
