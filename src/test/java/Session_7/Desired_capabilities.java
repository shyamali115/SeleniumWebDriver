package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Desired_capabilities 
{
WebDriver driver;
	
	@Before
	public void setup()
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		
		driver=new ChromeDriver(cap);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://cacert.com/");
	}
	
	@Test
	public void desired_cap()
	{
	 System.out.println(driver.getTitle());
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
