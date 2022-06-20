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

public class Alert_handling
{
    WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void alertpopup() throws InterruptedException
	{
		WebElement alertbtn= driver.findElement(By.xpath("//button[contains(text(),'click the button to display an alert box:')]"));
		
		alertbtn.click();
		
		Alert alert =driver.switchTo().alert();
		
		Thread.sleep(2000);
		
		System.out.println("Text of alert is : "+ alert.getText());
		
		Assert.assertEquals("Alert text is not matching"," I am an alert box!", alert.getText());
		alert.accept();
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
