package TestNG;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameters_enabled_optional {
	WebDriver driver;

	@Parameters("browserName")

	@BeforeTest
	@Test
	public void InitialiseBrowser(@Optional("edge") String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
		
			driver = new ChromeDriver();
			break;

		case "firefox":
		
			driver = new FirefoxDriver();
			break;

		case "edge":
		
			driver = new EdgeDriver();

			break;

		default:
			System.err.println("browser is invalid");
			break;
		}

		driver.manage().window().maximize();
	}

	@AfterTest
	@Test
	public void Teardown() {
		driver.close();
	}

	@Parameters("url")
	@Test
	public void LaunchPage( String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
	}

	@org.testng.annotations.Parameters( {"username","password"})
	@Test
	public void EnterLogin( String username,String password)  throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("btn-login")).click();
		Thread.sleep(2000);
	}

	@Test
	public void Appointment() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()=\"Make Appointment\"]"));
		
		 assertTrue(ele.isDisplayed());			
		System.out.println(ele.getText());
		
	
		
		
		
	}

	@Test
	public void SelectMethod() throws InterruptedException {
		String name = "Hongkong CURA Healthcare Center";
		WebElement dropdown = driver.findElement(By.id("combo_facility"));
		Select select = new Select(dropdown);
		List<WebElement> list = select.getOptions();
		for (WebElement ele : list) {
			String text = ele.getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(name)) {
				ele.click();
				Thread.sleep(2000);
			}

		}

	}

	@Test
	public void CheckBox1() {

		driver.findElement(By.id("chk_hospotal_readmission")).click();
		System.out.println(driver.findElement(By.id("chk_hospotal_readmission")).isSelected());
	}

	@Test
	public void RadioButton() throws InterruptedException {
		String value = "Medicaid";
		List<WebElement> radio = driver.findElements(By.name("programs"));

		for (WebElement ele1 : radio) {
			String att = ele1.getAttribute("value");
			if (att.equals(value)) {
				ele1.click();

			}
		}
		Thread.sleep(2000);
	}

	@Test
	public void DatePicker() throws InterruptedException {
		String month = "June 2024";
		String day = "21";
		driver.findElement(By.id("txt_visit_date")).click();
		Thread.sleep(2000);
		while (true) {
			String text = driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[3]")).click();
			}

			driver.findElement(By.xpath("//td[@class=\"day\"][text()=" + day + "]")).click();
		}
		Thread.sleep(2000);

	}
	

	@Test
	public void Comment() throws InterruptedException {
		driver.findElement(By.name("comment")).sendKeys("HELLO I AM ABHILASH I WANT APPOINTMENT");
		Thread.sleep(5000);

	}

	@Test
	public void BookAppointmentButton() throws InterruptedException {
		driver.findElement(By.id("btn-book-appointment")).click();
		Thread.sleep(2000);
	}
}
