package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class invoke_edge1 {

	public static void main(String[] args)
	{
		//System.out.println(System.getProperty("user.dir"+"/msedgedriver.exe"));
		
		//System.setProperty("webdriver.edge.driver", "C:\Shyamali\Course\MyProjects\Simple_seleniumWebdriver\msedgedriver.exe");
		 
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/msedgedriver.exe");
		
		
		WebDriver driver=new EdgeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		
		System.out.println("web page title is: " + driver.getTitle());
		
		
		driver.close();
		
		
	}
}
