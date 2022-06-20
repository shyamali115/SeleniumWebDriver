
package Session_6;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_tabhandling 
{
WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void window_tabhandling()
	{
		System.out.println("tab handling by using Set");
		
		WebElement clickbtn=driver.findElement(By.id("tabButton"));
		clickbtn.click();
		
		System.out.println("Current Window title is : "+ driver.getTitle());
		
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> it=handle.iterator();
		
		String parentwindowId=it.next();
		String childwindowId=it.next();
		
		System.out.println("Parent window id is : " + parentwindowId);
		
		driver.switchTo().window(childwindowId);
		
		System.out.println("child window title is : " + driver.getTitle());
		System.out.println("Child window id is : " + childwindowId);
		
		driver.close();
		
		driver.switchTo().window(parentwindowId);
		
		
		
		}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
