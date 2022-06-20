package Session_9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Webtable_checkboxhandling 
{
	    static WebDriver driver;
		String username="Koushik";
		
		@Before
		public void setup()
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get("https://letcode.in/table");
		}
			
		@Test
		public void checkbox_handling()
	
		{
			// finding the check box for the user with given name
			try 
			{
				WebElement checkboxForUser = driver.findElement(By.xpath("//td[text()='"+username+"']//parent::tr//td//input[@type='checkbox']"));
				checkboxForUser.click();
				Assert.assertTrue(checkboxForUser.isSelected());
				System.out.println("Checkbox for user \""+username+"\" is selected");
				
			} catch (Exception e) 
			{
				System.err.println("Unable to findout the username: " + username + " in the table");
				e.printStackTrace();
				e.getMessage();	
			}	
		}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
