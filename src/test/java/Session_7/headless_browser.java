package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headless_browser
{
WebDriver driver;
	
	@Before
	public void setup()
	{
	//	ChromeOptions options=new ChromeOptions();
	//	options.addArguments("headless");
	//  driver=new ChromeDriver(options);
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}
	
	@Test
	public void headless_driver()
	{
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation testing");
		
		WebElement searchbtn=driver.findElement(By.name("btnK"));
		searchbtn.sendKeys(Keys.ENTER);
		
		System.out.println("page title : "+ driver.getTitle());
		
		WebElement firstlink=driver.findElement(By.xpath("//div[@class='tF2Cxc']//h3[contains(text(),'What is automation testing?')]"));
		firstlink.click();
				
				
	}
		
	@After
	public void teardown() throws InterruptedException
	{
	   Thread.sleep(3000);
	   driver.quit();
	}
}
