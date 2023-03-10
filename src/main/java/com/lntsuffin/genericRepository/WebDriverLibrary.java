package com.lntsuffin.genericRepository;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLibrary {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;
	
	/**
	 * This method is used to launch the browser based on browser key
	 * maximize the browser
	 * provide implicit wait
	 * launch app by url
	 * @param browser
	 * @param url
	 * @param timeout
	 * @return
	 */
	public WebDriver launchApplication(String browser, String url, long timeout)
	{
		
		if(browser.equals("chrome"))
		{ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notification");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("please enter the valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);
		intiallizeExplicitWait(timeout);
		intiallizeActions();
		return driver;
	}
	/**
	 * This method is used to switch to alert window and click on OK button
	 */
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to switch to alert and click on Cancel button
	 */
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to switch to alert window and getting message from the alert window
	 * @return
	 */
	public String getTextAlert()
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to perfrom actions rather than using keyboard
	 */
	private void intiallizeActions()
	{
	act=new Actions(driver);	
	}
	/**
	 * wait for page based on duration
	 * @param timeout
	 */
	private void intiallizeExplicitWait(long timeout)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));	
	}
	/**
	* wait for page to load before indentifying any sychronized element in DOM [HTML-Docuent]
	* @param driver
	*/
	public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	* wait for page to load before indentifying any assychronized[java scripts actions] element
	in DOM [HTML-Docuent]
	* @param driver
	*/
	public void waitForPageToLoadForJSElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	 /**
	 * used to wait for element to be clickable in GUI , & check for specific element for every 500
	milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method used to wait till element visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	 /**
	 * used to wait for element to be clickable in GUI , & check for specific element for every 500
	milli seconds
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second
	* @throws Throwable
	 */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, Duration pollingTime)  {
	FluentWait wait = new FluentWait(driver);
	wait.pollingEvery(pollingTime);
	//wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
	try {
		wait.wait(20);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	* used to Switch to Any Window based on Window Title
	* @param driver
	* @param partialWindowTitle
	*/
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	 Set<String> set = driver.getWindowHandles();
	 Iterator<String> it = set.iterator();
	 while (it.hasNext()) {
	 String wID = it.next();
	 driver.switchTo().window(wID);
	 String currentWindowTitle = driver.getTitle();
	 if(currentWindowTitle.contains(partialWindowTitle)) {
	 break;
	 }
	 }
	}
	/**
	 * used to switch window and remove current windowtab
	 */
public void RemoveCurrentIdSwicthWin(WebDriver driver, String urldata) {
	String currentID=driver.getWindowHandle();
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext()) {
		String wid=it.next();
		driver.switchTo().window(wid);
		String url=driver.getCurrentUrl();
		System.out.println("URL_____________"+url);
		if(url != urldata) {
			break;
		}
	}
}
public void switchWinBasedOnUrl(WebDriver driver,String urldata) {
	Set<String> windowHandles = driver.getWindowHandles();

	// Switch to the second window tab
	for (String windowHandle : windowHandles) {
	    driver.switchTo().window(windowHandle);
	    if (driver.getCurrentUrl().contains(urldata)) {
	       
	    }
	    else {
	    	 break;
	    }
	}
}
	public void closeBrowser(ExcelLibrary excelLibrary, PropertyFileLibrary propertyFileLibrary) {
		// TODO Auto-generated method stub
		excelLibrary.closeExcel();
		propertyFileLibrary.closePropertyFile();
		driver.quit();
		
	}
}
