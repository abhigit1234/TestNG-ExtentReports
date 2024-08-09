package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCount_ThreadPoolSize {
	@Test(invocationCount = 3, threadPoolSize = 2)
	public  void invocation() throws InterruptedException {

		
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