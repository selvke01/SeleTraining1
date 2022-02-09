package testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ImmersiveTraining_GooglePageTest2 {
	
	WebDriver driver;
	
	@BeforeMethod 
	public void setUp() {
		 
		//Normal
		 System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
			 
	   //Using WebDriver Manager by adding the plugin
			 /*WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();*/
		 }
		 

	@Test(groups = {"featureTwo"})
	   public void JavaSearchTestSuccess() {	   
		System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		  driver.get("https://www.google.com"); 
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("Javatutorial");
		  
		  searchBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Javatutorial - Google Search");
	   }
	  
	@Test(groups = {"featureThree"})
	   public void JavaSearchTestFailure() {	 
		System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		  driver.get("https://www.google.com"); 
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("Javatutorial");
		  
		  searchBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Javatutorial - GoogleSearch");
	   }
	
	   @AfterMethod
	   public void tearDown() {
		  driver.quit();
	   }
}
