package Session_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class listoflinksfromwebpage 
{
		@Test
		public void findlinks()
		{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in");
		
		
		List<WebElement> linksonpage =driver.findElements(By.tagName("a"));
		
		System.out.println("Total no of links on page: "+ linksonpage.size());
		
		
		System.out.println("Print all the text");
		
		for(int i=0;i<linksonpage.size();i++)
		{
			
		   if(!(linksonpage.get(i).getText().isEmpty()))
		   {
			   System.out.println((i+1)+". "+ linksonpage.get(i).getText());
			   
		   }
		}
		
		driver.quit();
		}
}
