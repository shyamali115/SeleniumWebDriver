package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class interactwith_Xpath_7 
{
	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//driver.get("http://demo.automationtesting.in/Register.html");
		driver.get("http://demo.automationtesting.in/Register.html");
		System.out.println("page title is: "+driver.getTitle());
		
		WebElement Userfirstname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		Userfirstname.sendKeys("tom");
		
		WebElement Userlastname=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		Userlastname.sendKeys("steve");
		
		WebElement UserAddress=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		UserAddress.sendKeys("asssdhjksjkd");
		
		WebElement radiobtn=driver.findElement(By.xpath("//input[@value='Male']"));
		radiobtn.click();
		
		WebElement checkbox=driver.findElement(By.id("checkbox2"));
		checkbox.click();
		
		
		Thread.sleep(3000);
		driver.quit();
	
	
	
	}
	
		
}
