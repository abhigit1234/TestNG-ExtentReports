package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeOuts_ExpectedExceptions {
  //=====Exceptions==NoSuchElementException.class,TimeoutException.class,ThreadTimeoutException.class,IOException.class
	
	@Test( expectedExceptions = {})
	public void LoginPage() throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https:www.google.com");
		//driver.findElement(By.id("d")).sendKeys("abhi");
		driver.close();
	}
	
	
	
	
	
	/*
  	@Test(timeOut = 10000)
	public void LoginPage() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:www.google.com");
		driver.close();
	}
*/
	

}