package Session_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown_withoutselectclass_1
{

	WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void dropdow_withoutselect() throws InterruptedException
	{
		List<WebElement> yearlist= driver.findElements(By.xpath("//select[@id='yearbox']/option"));
		System.out.println("Options are: ");
		
		for(int i=0; i<yearlist.size(); i++)
		{
			System.out.println(yearlist.get(i).getText());
			if(yearlist.get(i).getText().equals("1967"))
			{
				yearlist.get(i).click();
			}
		}
		
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}
}
