package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestCase {
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://r33.coupadev.com/");
	}
	
	@Test()
	public void validateTitle(){
		String title = driver.getTitle();
		Assert.assertEquals(title, "Coupa Home");
	}
	
	@Test()
	public void validateLogo(){
		boolean logo = driver.findElement(By.className("logo")).isDisplayed();
		Assert.assertEquals(logo, true);
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
