package Session_3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class introto_junit 
{

	String url="https://www.amazon.in";
	WebDriver driver;
	String prodname="iphone13";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(url);
	}
	
	
	@Test
	public void titlevalidation()
	{
		String exptitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String acttitle= driver.getTitle();
		
//		if (exptitle.equals(acttitle))
//		{
//			System.out.println("Title matched");
//		}
//		else
//		{
//			System.out.println("test fail");
//		}
		
		Assert.assertEquals("Title do not match", exptitle, acttitle);
		//System.out.println("test pass");
	}
		
	@Test	
	public void searchprod() throws InterruptedException
	{
		WebElement searchtb=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	//	searchtb.sendKeys("iphone13");
		searchtb.sendKeys(prodname);
		
		WebElement searchbtn=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbtn.click();
		
		Thread.sleep(3000);
		
		WebElement searchResult=driver.findElement(By.xpath("//span[text()='RESULTS']"));
		
		boolean expresult=true;
		boolean actresult=searchResult.isDisplayed();
		
		Assert.assertEquals("Result is not Displayed",expresult,actresult);
	

	
	}
	
//		
		
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
