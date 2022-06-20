package Session_6;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_handling
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
		WebElement framebtn=driver.findElement(By.xpath("//li[@class='active']//a[@class='analystic']"));
		framebtn.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));
		
		WebElement textboxbtn=driver.findElement(By.xpath("//input[@type='text']"));
		textboxbtn.sendKeys("test");
		
		driver.switchTo().defaultContent();
		
		WebElement pagecentertext=driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']"));
		System.out.println(pagecentertext.getText());
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
