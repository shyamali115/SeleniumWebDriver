package Session_4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicpara_xpath_2
{
  
	WebDriver driver;
	String texttobeclicked="pepe shirt";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com");
		
		
	}
	
	@Test
	public void searchboxtest() throws InterruptedException
	{
		WebElement searchbox=driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchbox.sendKeys("pepe");
		Thread.sleep(3000);
		WebElement searchitem=driver.findElement(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null' and text()='Pepe Tshirt']"));
		searchitem.click();
	
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
}
