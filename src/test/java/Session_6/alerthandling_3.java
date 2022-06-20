package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class alerthandling_3 
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void alert_texthandling() throws InterruptedException
	{
		WebElement alerttypeselection=driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
		alerttypeselection.click();
		
		WebElement alertbtn=driver.findElement(By.xpath("//button[contains(text(), 'click the button to demonstrate the prompt box ')]"));
		alertbtn.click();
		
		Alert alert=driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		alert.sendKeys("Tom Peter");
		Thread.sleep(3000);
		
		alert.accept();
		
		WebElement alertconfirmsg= driver.findElement(By.xpath("//p[@id='demo1']"));
		
		
		Assert.assertEquals(true, alertconfirmsg.getText().contains("Tom Peter"));
	}
	
	@After 
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
