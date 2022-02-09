package testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImmersiveTraining_Synchr {
	
	WebDriver driver;
  	// @BeforeMethod
	@BeforeTest public void setUp() {
		 
	//Normal
	 System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
	 driver = new ChromeDriver(); 
	 driver.manage().window().maximize();
	}
	@Test
	   public void JavaSearchTestSuccess() {	   
		System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		  driver.get("https://www.google.com"); 
		  long id = Thread.currentThread().getId();
		  System.out.println("Thread ID: "+id);
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("Javatutorial");
		  
		  searchBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Javatutorial - Google Search");
	   }
	@AfterMethod
	   public void tearDown() {
		  driver.quit();
	   }
}
