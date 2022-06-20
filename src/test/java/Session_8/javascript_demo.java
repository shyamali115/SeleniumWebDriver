package Session_8;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class javascript_demo 
{

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	String URL = "https://www.google.com";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		wait = new WebDriverWait(driver, 15);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	
	@Test
	public void javascript_1()
	{
		WebElement searchbox=driver.findElement(By.name("q"));
		
		javaScriptUtil.drawBorder(searchbox);
		
		javaScriptUtil.flash(searchbox);
		
		searchbox.sendKeys("Selenium");
		
		WebElement searchbtn=driver.findElement(By.name("bnK"));
		
		//javaScriptUtil.clickElementByJS(searchbtn);
		searchbtn.click();
		
		
	}
	
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
