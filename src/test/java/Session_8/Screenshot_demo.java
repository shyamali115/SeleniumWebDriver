package Session_8;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshot_demo
{
	WebDriver driver;
	WebDriverWait wait;
	String url="https:www.google.co.in";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		wait=new WebDriverWait(driver,15);
		
	}
	
	@Test
	public void screenshot_1()
	{
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("Appium tool");
		
		WebElement searchbtn=driver.findElement(By.name("btnK"));
		searchbtn.click();
		
		wait.until(ExpectedConditions.titleContains("Appium Tool"));
		
		screenshotcapture(driver,"Appium tool");
	}
	
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public static void screenshotcapture(WebDriver driver, String filenametobe)
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "src\\test\\java\\screen_shot/"+filenametobe+System.currentTimeMillis()+".jpg"));
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
}
