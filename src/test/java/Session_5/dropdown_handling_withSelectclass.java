package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class dropdown_handling_withSelectclass 
{
		WebDriver driver;
		
		@Before
		public void setup()
		{
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.facebook.com");
		}
		@Test
		public void dropdown()
		{
			WebElement createbtn=driver.findElement(By.xpath("//a[@role='button' and text()='Create New Account']"));
			createbtn.click();
			
			WebElement birthday=driver.findElement(By.id("day"));
			WebElement birthmonth=driver.findElement(By.id("month"));
			WebElement birthyear = driver.findElement(By.id("year"));
			
			Select dayselect=new Select(birthday);
			dayselect.selectByIndex(1);
			
			Select monthselect=new Select(birthmonth);
			monthselect.selectByValue("10");
			
			Select yearselect=new Select(birthyear);
			yearselect.selectByVisibleText("1989");
		}
		
		@After
		public void teardown() throws InterruptedException
		{
				Thread.sleep(3000);
				driver.quit();
		
		}
		
		
}
