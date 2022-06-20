package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_handling_1 
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	}
	
	
	@Test
	public void frame_handling()
	{
		WebElement multiframebtn=driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		multiframebtn.click();
		
		WebElement frame1=driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(frame1);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='row']/iframe")));
		
		WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
		textbox.sendKeys("test");
		
		//driver.switchTo().defaultContent();
		
	//	or
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	

}
