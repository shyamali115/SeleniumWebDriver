package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class interactwith_classname_3 {

	public static void main(String[] args) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.get("http://zero.webappsecurity.com/");
	
	System.out.println("page title is: "+driver.getTitle());
	
	WebElement signinbutton = driver.findElement(By.className("signin"));
	//WebElement signinbutton = driver.findElement(By.id("signin_button"));
	
	signinbutton.click();
	
	
	String nextpage = driver.getTitle();
	System.out.println(nextpage);
	
	WebElement usernameTB= driver.findElement(By.id("user_login"));
	WebElement passwordTB= driver.findElement(By.name("user_password"));
	WebElement Signbutton= driver.findElement(By.className("btn"));
	
	usernameTB.sendKeys("username");
	passwordTB.sendKeys("password");
	Signbutton.click();
	
	Thread.sleep(3000);
	
	driver.quit();
	}

}
