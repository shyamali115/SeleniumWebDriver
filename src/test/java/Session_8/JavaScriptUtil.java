package Session_8;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil 
{
	
		WebDriver driver;
	
		
		public JavaScriptUtil(WebDriver driver)
		{
			this.driver = driver;
		}
		
		/**
		 * This method will scroll the page until the element is not visible on the page
		 * @param WebElement variable
		 * @param WebDriver variable
		 */
		public void scrollIntoView(WebElement element, WebDriver driver) 
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public void drawBorder(WebElement element) 
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		public void flash(WebElement element)
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			String bgcolor = element.getCssValue("backgroundColor");
			for (int i = 0; i < 20; i++) 
			{
				changeColor("rgb(0,200,0)", element);// 1
				changeColor(bgcolor, element);// 2
			}
		}
		
		public void changeColor(String color, WebElement element) 
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

			try
			{
				Thread.sleep(20);
				
			} catch (InterruptedException e)
			{
			}
		}
}
