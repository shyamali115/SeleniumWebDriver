package Session_10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Webdata_sorting
{
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("WebDriver.chrome.driver","ChromeDriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		
	}
	
	@Test
	public void data_sorting()
	{
		List<WebElement> listofcountries=driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		
		String array_1[]=new String[listofcountries.size()];
		
		for(int i=0;i<array_1.length;i++)
		{
			array_1[i]=listofcountries.get(i).getText();
			
		}
			
		System.out.println("------------------------------- Default values ------------------------------------");
		printArray(array_1);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("-----------------sort values-------------");
		Arrays.sort(array_1);
		printArray(array_1);
		System.out.println("-----------------------------------------------------------------------------------");	
			
		driver.findElement(By.xpath("//button[text()='Sort']")).click();

		listofcountries = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		String[] array_2 = new String[listofcountries.size()];

		for (int i = 0; i < array_2.length; i++)
		{
			array_2[i] =  listofcountries.get(i).getText();
		}
		
		System.out.println("------------ Sorted values form after clicking on sort button on page --------------");
		printArray(array_2);
		System.out.println("------------------------------------------------------------------------------------");
		
		Assert.assertEquals(array_1, array_2);
			
	}
	
	public static void printArray(String[] array)
	{
		for (int i = 0; i < array.length; i++) 
		{
			System.out.println(array[i]);
		}
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
