package testNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImmersiveTraining_DataParams {
	
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
	 }
	}
	
  //@Parameters({"username", "password"})
  @Test(dataProvider = "loginData")
  public void loginTest(String uName, String pWord) {
	  driver.get("http://the-internet.herokuapp.com/login");
	  //driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.id("username")).sendKeys(uName);
	  //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.id("password")).sendKeys(pWord);
	  driver.findElement(By.className("radius")).click();
  }
  
  @DataProvider(name="loginData")
  public Object[][] getData(){
	  return new Object[][] {
		  new Object[] {"testuser1", "welcome1"},
		  new Object[] {"testuser2", "welcome2"},
		  new Object[] {"tomsmith", "SuperSecretPassword!"}
	  };
  }
  
  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }
}
