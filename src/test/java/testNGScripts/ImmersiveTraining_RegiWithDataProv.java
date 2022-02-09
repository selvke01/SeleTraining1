package testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImmersiveTraining_RegiWithDataProv {
	
	WebDriver driver;
	//@BeforeTest
	@Parameters("browser")
    @BeforeMethod
	public void setUp(String strBrowser) {
	
	 System.out.println("Parameter :"+strBrowser);
	 
	 if(strBrowser.equalsIgnoreCase("chrome")) {		 
	//Normal
	 System.setProperty("webdriver.chrome.driver", "/Users/krish/Documents/Family/Keerthana/Selenium/Selenium Projects/chromedriver.exe"); 
	 driver = new ChromeDriver(); 
	 driver.manage().window().maximize();
	 }
	 else if(strBrowser.equalsIgnoreCase("edge")){
		 WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 driver.manage().window().maximize();
	 }
	}
	
  @Test(dataProvider = "registerData")
  public void Registration(String fname, String lname, String mail, String phNo, String pword, String confpword) throws InterruptedException {
	  driver.get("https://demo.opencart.com/index.php?route=account/register");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[contains(text(), 'My Account')]")).click();
	  driver.findElement(By.linkText("Register")).click();
	  
	  Assert.assertEquals(driver.getTitle(), "Register Account");
	  
	  driver.findElement(By.id("input-firstname")).sendKeys(fname);
	  driver.findElement(By.id("input-lastname")).sendKeys(lname);
	  driver.findElement(By.id("input-email")).sendKeys(mail);
	  driver.findElement(By.id("input-telephone")).sendKeys(phNo);
	  driver.findElement(By.id("input-password")).sendKeys(pword);
	  driver.findElement(By.id("input-confirm")).sendKeys(confpword);
	  
	  WebElement newsLetterNo = driver.findElement(By.xpath("//input[@value=\"0\"]"));
	  if(!newsLetterNo.isSelected())
		  newsLetterNo.click();
	  
	  driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
	  driver.findElement(By.xpath("//input[@value=\"Continue\"]")).submit(); 
	  
	  String accCreated = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
	  
	  if(accCreated.contains("Your Account Has Been Created!"))
		  System.out.println("Account has been created Successfully");
	  else
		  System.out.println("Account is not created Successfully");
	  
  }
  
  @DataProvider(name="registerData")
  public Object[][] getData(){
	  return new Object[][] {
		  new Object[] {"Test1", "Name1", "test32022@gmail.com", "9324234324", "test1", "test1"},
		  new Object[] {"Test2", "Name2", "test42022@gmail.com", "9324234325", "test2", "test2"}
		  //new Object[] {"testuser2", "welcome2"},
		  //new Object[] {"tomsmith", "SuperSecretPassword!"}
	  };
  }
  
  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }
}
