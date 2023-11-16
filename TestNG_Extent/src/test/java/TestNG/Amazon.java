package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	WebDriver driver;

	
	@Test
	public void LaunchAmazon() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}

	@Test
	public void SearchItem() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Boat Rockerzz", Keys.ENTER);
		System.out.println(driver.getTitle());
	}

	@Test
	public void VerifyDepartment() {
		System.out.println(driver.findElement(By.id("departments")).getText());
		driver.close();
	}

}