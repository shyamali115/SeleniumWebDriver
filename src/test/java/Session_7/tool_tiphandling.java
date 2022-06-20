package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class tool_tiphandling 
{
WebDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips/");
	}
		
	
	
	/*@Test
	public void tooltip_handling() throws InterruptedException
	{
		
		WebElement hoverbtn=driver.findElement(By.id("toolTipButton"));
		Thread.sleep(6000);
		
		Actions act=new Actions(driver);
		act.moveToElement(hoverbtn).build().perform();
		
		Thread.sleep(3000);
		
		WebElement movehoverbtn= driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		
		String suggestiontext=movehoverbtn.getText();
		System.out.println("Suggetion box text is" +suggestiontext);
		
		Assert.assertEquals("You hovered over the Button", suggestiontext);
		
	}*/
	
	@Test
	public void tip_handling_1() throws InterruptedException
	{
		WebElement hovertextbox=driver.findElement(By.id("toolTipTextField"));
		Thread.sleep(6000);
		
		Actions act=new Actions(driver);
		act.moveToElement(hovertextbox).build().perform();
		
		Thread.sleep(3000);
		
		WebElement movehovertextbox= driver.findElement(By.xpath("//div[text()='You hovered over the text field']"));
		
		String suggestiontext=movehovertextbox.getText();
		System.out.println("Suggetion box text is : " +suggestiontext);
		
		Assert.assertEquals("You hovered over the text field", suggestiontext);
		
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
