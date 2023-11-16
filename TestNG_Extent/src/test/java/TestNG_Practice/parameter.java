
package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameter {
	WebDriver driver;
	@Parameters("browser")
	
	@BeforeTest

	@Test
	public void initializeBrowser(@Optional ("firefox") String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default: System.out.println("invalid browser");
			break;
		}
		
		
	}
	@AfterTest
	
	@Test
	public void tearDown() {
		driver.close();
	}

	@Parameters("url") 
	@Test
	public void launch(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}
	
	@Test
	public void enterStore() {
		driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
	}
	@Test
	public void fish() {
		driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]")).click();
	}
	@Test
	public void verifyReturnMenu() {
	System.out.println(driver.findElement(By.xpath("//*[@id=\"BackLink\"]/a")).getText());
		
	}

	@Test
	public void selectProduct() {
	driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[4]/td[1]/a")).click();
		
	}
	@Test
	public void addtocart() {
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
	}

	@Test
	public void checkout() {
		driver.findElement(By.xpath("//*[@id=\"Cart\"]/a")).click();
	}

}
