package TestNG;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCount_ThreadPoolSize {
	@Test(invocationCount = 3, threadPoolSize = 2)
	public  void invocation() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.randomuser.me");
Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[1]")).click();
		System.out.println("username : "+ driver.findElement(By.id("user_value")).getText());
		
		driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[2]")).click();
		System.out.println("email : "+ driver.findElement(By.id("user_value")).getText());
		driver.close();
	}

}