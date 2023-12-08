package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor js;
	// Create Contractor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		js =  (JavascriptExecutor) driver;
	}
	// sleep method
	public static void sleep(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// click method 
	public static void ClickButton (WebElement button)
	{
		sleep(2);
		button.click();
	}
	// sendkey method
	public static void SetElementText (WebElement TextElement , String Value)
	{
		TextElement.clear();
		TextElement.sendKeys(Value);
	}

	public void ScrollDown()
	{
		js.executeScript("window.scrollBy(0,800)");
	}
}
