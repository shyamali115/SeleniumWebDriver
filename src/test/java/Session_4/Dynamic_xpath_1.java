package Session_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_xpath_1 {
	
	WebDriver driver;
	
	String Texttobeclicked="Pepe Jeans Shirts";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com");
		
	}
			
	@Test
	public void searchboxtest() throws InterruptedException
	{
		WebElement searchbox=driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		
		searchbox.sendKeys("Pepe");
		
		Thread.sleep(3000);
		
		List <WebElement> searchlist=driver.findElements(By.xpath("//ul[@class='desktop-group']/li[@class='desktop-suggestion null']"));
		System.out.println("Count is: "+searchlist.size());
		
		for(int i=0;i<searchlist.size();i++)
		{
		//	System.out.println(searchlist.get(i).getText());  //print all options
			
			if(searchlist.get(i).getText().equals(Texttobeclicked))
			{
				searchlist.get(i).click();
				
			}
			
		}
		
		Thread.sleep(3000);
	}
	
	
	
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}
