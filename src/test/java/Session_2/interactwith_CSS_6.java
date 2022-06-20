package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class interactwith_CSS_6 {
	public static void main(String[] args) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.get("http://www.google.co.in");
	
	System.out.println("page title is: "+driver.getTitle());
	
	
	System.out.println("test test");
	
	WebElement searchtextbox = driver.findElement(By.cssSelector("input.gLFyf "));
	searchtextbox.sendKeys("Selenium Webdriver");
	
	Thread.sleep(3000);
	
	driver.close();
	
	
	
	
	
	
	}

}
