package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerthandling_1 
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
		
		@Test
		public void dropdown() throws InterruptedException
		{
			WebElement alerttypeselection =driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
			alerttypeselection.click();
			
			WebElement alertbtn=driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
			alertbtn.click();
			
			Alert alert=driver.switchTo().alert();
			
			Thread.sleep(3000);
			alert.dismiss();
			
			WebElement alertconfirmsg= driver.findElement(By.xpath("//p[@id='demo']"));
			
			Assert.assertEquals("text is not matching", "You Pressed Cancel", alertconfirmsg.getText());
			
			
		}
		@After
		public void teardown() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
			
		}

}
