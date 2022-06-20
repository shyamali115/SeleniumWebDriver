package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class invoke_firefox {
	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("user.dir"+"/geckodriver.exe"));
		
		//System.setProperty("webdriver.gecko.driver", "C:\Shyamali\Course\MyProjects\Simple_seleniumWebdriver\geckodriver.exe");
		 
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver.exe");
		
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		
		System.out.println("web page title is: " + driver.getTitle());
		
		
		
		
	}

}
