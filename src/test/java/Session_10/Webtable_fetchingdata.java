package Session_10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_fetchingdata 
{
              String dessertname;
              static WebDriver driver;
              
              
      @Before
      public void setup()
      {
    	  System.setProperty("WebDriver.chrome.driver", "ChromeDriver.exe");
    	  driver = new ChromeDriver();
  		  driver.manage().window().maximize();
  		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  		  driver.manage().deleteAllCookies();
    	  
      }
      
      
      @Test
      public void tabledata_fetching()
      {
    	  System.getProperty("https://letcode.in/table");
    	  
    	//  List<WebElement> dessertlist= driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[text()='Ice cream']//following-sibling::td[text()]"));
    	  List<WebElement> dessertlistelement = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[text()='"+dessertname+"']//following-sibling::td[text()]"));
    	  
    //	  System.out.println("Desserts are : \""+dessertname+"\"as below");
    	  System.out.println("The nutritional breakup for the desert \""+ dessertname +"\" as below");
    	  
    	  for (int i=0; i<dessertlistelement.size(); i++)
    	  {
    		  System.out.println((i+1)+" . "+ dessertlistelement.get(i).getText());
    	  }
    	  
      }
      
      @After
      public void teardown() throws InterruptedException
      {
    	  Thread.sleep(3000);
    	  driver.quit();
    	  
    	  
      }
      
      
      
      
      
      
      
      
}
