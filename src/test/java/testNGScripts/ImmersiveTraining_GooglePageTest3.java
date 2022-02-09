package testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ImmersiveTraining_GooglePageTest3 {
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
	// don't want to execute means
	// @Test(enabled=false)
	// Setting priority
	//@Test(priority=1)
	@Test(dependsOnMethods = "JavaSearchTest")
	   public void JavaSearchTestSuccessAppium() {	 
		System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 

		  driver.get("https://www.google.com"); 
		  driver.manage().window().maximize();
		  long id = Thread.currentThread().getId();
		  System.out.println("Thread ID: "+id);
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("Appiumtutorial");
		  
		  searchBox.submit();
		  Assert.assertEquals(driver.getTitle(), "Appiumtutorial - Google Search");
	   }
	
	
	 
   //@Test(priority=3)
   @Test (groups = {"featureOne"})
   public void JavaSearchTest() {	   
	   System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 
		
	  driver.get("https://www.google.com"); 
	  driver.manage().window().maximize();
	  long id = Thread.currentThread().getId();
	  System.out.println("Thread ID: "+id);
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Javatutorial");
	  
	  //Soft Assert
	  SoftAssert softAssert = new SoftAssert();	  
	  
	  searchBox.submit();
	  softAssert.assertEquals(driver.getTitle(), "Javatutorial - Google");
	  softAssert.assertAll();
   }
   
   //@Test
   @Test (groups = {"featureTwo"})
   public void JavaSearchTest1() {	   
	   System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
		 driver = new ChromeDriver(); 		
	  driver.get("https://www.google.com"); 
	  driver.manage().window().maximize();
	  long id = Thread.currentThread().getId();
	  System.out.println("Thread ID: "+id);
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Javatutorial");
	  
	  //Soft Assert
	  SoftAssert softAssert = new SoftAssert();	  
	  
	  searchBox.submit();
	  softAssert.assertEquals(driver.getTitle(), "Javatutorial - Google Search");
	  softAssert.assertAll();
   }
  
  
 
  // @AfterMethod
@AfterTest
   public void tearDown() {
	  driver.quit();
   }
}
