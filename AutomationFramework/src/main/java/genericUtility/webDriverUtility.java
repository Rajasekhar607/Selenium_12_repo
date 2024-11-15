package genericUtility;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class webDriverUtility {
	public WebDriver driver;
	
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to capture size of a window
	 * @param driver
	 * @return 
	 * @return
	 */
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}
	/**
	 * This method is used to switch driver control to window based on url
	 * @param driver
	 * @param url
	 */
	public void switchToWindow(WebDriver driver,String url) {
		// step-1: capture window ids
		Set<String> allWindowsIds = driver.getWindowHandles();
		// Step-2: navigate through all windows
		for(String id:allWindowsIds) {
			
		driver.switchTo().window(id);
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(url)) {
			break;
			
			
		}
	}
		
		}
	public void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	public void cickAndHold(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseHover(WebDriver driver,int x ,int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}
	public void dragAndDrop(WebDriver driver,int x,int y) {
		Actions act=new Actions(driver);
		act.dragAndDropBy(null, x, y).perform();
		
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void siwtchToFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
		
	}
	public void switchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		
	}
	public void switchBackToMainpage(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	public void selectDropdownByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	public void selectDropdownByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectDropdownByVisibleText(WebElement element,String text ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
		
	}
	public void SwitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void SwitchToAlertAndDismis(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void SwitchToAlertAndSendkeys(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	public void jsScroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy("+x+","+y+")");
	}
}
	


	
	
	


