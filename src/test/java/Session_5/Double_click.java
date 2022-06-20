package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Double_click 
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		
	}
	@Test
	public void dropdown() throws InterruptedException
	{
		WebElement doubleclickbtn=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		
		Thread.sleep(3000);
		
		Actions act=new Actions(driver);
		
		act.doubleClick(doubleclickbtn).build().perform();
		Thread.sleep(3000);
	
	}
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}
		
		
	
	
}

