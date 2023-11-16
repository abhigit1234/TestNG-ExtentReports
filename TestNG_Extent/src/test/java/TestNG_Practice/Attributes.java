package TestNG_Practice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Attributes {

	@Test(invocationCount = 4,threadPoolSize = 2,invocationTimeOut = 1000)
	public void test1() throws InterruptedException {
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[1]")).click();
	WebElement ele1 =	driver.findElement(By.id("user_value"));
		System.out.println(ele1.getText());
		
	driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[2]")).click();
	WebElement ele2 = driver.findElement(By.id("user_value"));
	System.out.println(ele2.getText());
	
	driver.quit();
		
	
	
	}
	
	
	
}
