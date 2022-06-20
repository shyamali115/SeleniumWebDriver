package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class DragandDrop
{
	WebDriver driver;
	
	@Before
	public void setup()
	{		
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demoqa.com/droppable");
	
	}
	
	@Test
	public void DropDown() throws InterruptedException
	{
		WebElement element1=driver.findElement(By.id("draggable"));
	//	WebElement element1= driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropArea=driver.findElement(By.id("droppable"));
	//	WebElement dropArea=driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
			
		Actions act=new Actions(driver);
		
		Thread.sleep(3000);
		
		act.dragAndDrop(element1, dropArea).build().perform();
		
		WebElement droppedtextelement=driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		Assert.assertEquals("The action is not perform","Dropped!" , droppedtextelement.getText());
	
	} 
	
	
	
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
