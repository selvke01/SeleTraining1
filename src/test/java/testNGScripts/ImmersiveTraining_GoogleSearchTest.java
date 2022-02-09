package testNGScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ImmersiveTraining_GoogleSearchTest {
	
  WebDriver driver;
  	// @BeforeMethod
	@BeforeTest public void setUp() {
		 
	//Normal
	 System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
	 driver = new ChromeDriver(); 
	 driver.manage().window().maximize();
		 
   //Using WebDriver Manager by adding the plugin
	/*
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 */
	 }
	
	//@Test(priority=2)
	@Test(groups = {"featureOne"})
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
	// don't want to execute means
	// @Test(enabled=false)
	// Setting priority
	//@Test(priority=1)
	@Test(dependsOnMethods = "JavaSearchTest")
	   public void JavaSearchTestSuccessAppium() {	 
		System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		  driver.get("https://www.google.com"); 
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("Appiumtutorial");
		  
		  searchBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Appiumtutorial - Google Search");
	   }
	 
   //@Test(priority=3)
   @Test
   public void JavaSearchTest() {	   
	   System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
	  driver.get("https://www.google.com"); 
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Javatutorial");
	  
	  //Soft Assert
	  SoftAssert softAssert = new SoftAssert();	  
	  
	  searchBox.submit();
	  softAssert.assertEquals(driver.getTitle(), "Javatutorial - Google");
	  softAssert.assertAll();
   }
  
  // @AfterMethod
@AfterTest
   public void tearDown() {
	  driver.quit();
   }
  
}
