package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoke_chrome {
	
	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("user.dir"+"/chromedriver.exe"));
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Shyamali\\Course\\MyProjects\\Simple_seleniumWebdriver\\chromedriver.exe");
		 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		
		System.out.println("web page title is: " + driver.getTitle());
		
		
		
		
	}
	

}
