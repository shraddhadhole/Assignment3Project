package liveguru99.updatevalue;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class Sample3 {
	
	public WebDriver driver;
	
	
  @Test(priority=1)
  public void Clickonmobile() {
	  
	   driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile.html']")).click();
	  List<WebElement>allmlist=driver.findElements(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']"));
	  List<String>lit=new ArrayList<>();
	  for(WebElement y:allmlist)
	  {
		 lit.add(y.getText());
	  }
  }
  @Test(priority=2)
  public void addtocrt()
  {
	  driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	  
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
	  
	 driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
	  
	  driver.findElement(By.xpath("//button[@class='button btn-update']")).click();
	  
  }
  @Test(priority=3)
  
public void Clickonemptycard()
{
driver.findElement(By.xpath("//button[@value='empty_cart']/span/span")).click();
}
  
  
 @Test(priority=4)
 public void Comparebotherrormsg()
 {
	 //WebElement actual=driver.findElement(By.xpath("//div[@class='main-container col1-layout']/div/div/div/h1"));
	 
	 String exp="Shopping Cart is Empty";
	 String actual=driver.getTitle();
	 Assert.assertEquals(actual, exp);
	 System.out.println("Error msg verify");
 }
  
 
  @BeforeClass
  public void Maximize_browser() {
	  driver.manage().window().maximize();
  }

  @BeforeTest
  public void Enter_Application() {
	  
	  driver.get("http://live.guru99.com/");
  }

  @BeforeSuite
  public void Open_browser() {
	  
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium data\\chromedriver_win32(1)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }

}
