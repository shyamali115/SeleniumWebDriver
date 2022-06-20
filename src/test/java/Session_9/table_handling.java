package Session_9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class table_handling 
{
     static WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://letcode.in/table");
	}
	
	@Test
	public void table_handling_1()
	{
		
		List<WebElement> pricesFromTableListElement = driver.findElements(By.xpath("//table[@id='shopping']//tbody/tr/td[2]"));
		
		WebElement totalprice=driver.findElement(By.xpath("//table[@id='shopping']//tfoot/td/b"));
		
	//	System.out.println("Item Size : "+ pricesFromTableListElement.size());
		
	//	System.out.println("Total price : " + totalprice.getText());
		
        int sum = 0;
		
		for (int i = 0; i < pricesFromTableListElement.size(); i++) 
		{
			sum += Integer.parseInt(pricesFromTableListElement.get(i).getText());
		}
		if (sum == Integer.parseInt(totalprice.getText()))
		{
			Assert.assertTrue(true);
			System.out.println("Total is matching");
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Total is not matching");
		}
		
	}
	
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
