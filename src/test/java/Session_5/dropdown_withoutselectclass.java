package Session_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dropdown_withoutselectclass 
{
		WebDriver driver;
		
		@Before
		public void setup()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		}
		
		@Test
		public void dropdow_withoutselect() throws InterruptedException
		{
			WebElement clickbtn= driver.findElement(By.xpath("//span[text()='right click me']"));
					
			Actions act = new Actions(driver);
			act.contextClick(clickbtn).build().perform();
			
			List <WebElement> rightclickoptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//li/span"));
			
			System.out.println("Options are: ");
			
			for(int i=0; i<rightclickoptions.size();i++)
			{
				
				System.out.println((i+1)+": "+rightclickoptions.get(i).getText());
				if(rightclickoptions.get(i).getText().equals("copy"))
				{
					Thread.sleep(2000);
					rightclickoptions.get(i).click();
					Thread.sleep(2000);
					
				}
				
			
			}
		}
		
		@After
		public void teardown() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
			
		}
}
