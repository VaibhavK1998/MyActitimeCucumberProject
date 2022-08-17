package org.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {
 static WebDriver driver;
	
	public WebDriver startup(String browserName,String url) { // return type of this method is WebDriver
		// refrence which is here driver

		WebDriver driver=null; // here we declare the refrence of interface

		if(browserName.equalsIgnoreCase("CH")|| browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();
		} 

		else if(browserName.equalsIgnoreCase("ff")|| browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();

	 		driver=new FirefoxDriver();
	  	}
		else if(browserName.equalsIgnoreCase("ed")|| browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();//upcasting EdgeDriver memory in WebDriver class

		} 
		else {
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();//it will maximize the browser
		//driver.manage().window().setSize(new Dimension(300,300));// it will open browser and set the size of browser 
		// in given dimension
		try {               
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("catch block");
			e.printStackTrace();
		}
		driver.get(url); // it opens the url
		return driver;
	}
	
public WebDriver newStartUp(String browserName) {

	 // return type of this method is WebDriver
		// refrence which is here driver

		WebDriver driver=null; // here we declare the refrence of interface

		if(browserName.equalsIgnoreCase("CH")|| browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();
		} 

		else if(browserName.equalsIgnoreCase("ff")|| browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();

	 		driver=new FirefoxDriver();
	  	}
		else if(browserName.equalsIgnoreCase("ed")|| browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();//upcasting EdgeDriver memory in WebDriver class

		} 
		else {
			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();//it will maximize the browser
		//driver.manage().window().setSize(new Dimension(300,300));// it will open browser and set the size of browser 
		// in given dimension
		try {               
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("catch block");
			e.printStackTrace();
		}
		return driver;
}
	
public void clickByJavaScript(WebDriver driver,WebElement ele){// this method works to click on radiobutton,check and drpdown         
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ele);
	}

	public void scrolltillelementbyJs(WebDriver driver,WebElement ele){// this method works to scroll the page    
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);

	}
	public void scrollByPage(WebDriver driver,WebElement ele,int num) {
		for(int i=0;i<=num;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);//keys is enum it has method for all
		}                                                              //tab which is present in keyboard
	}

	public static void MoveByTab(WebDriver driver,int num) {
		for(int i=0;i<=num;i++) {
			driver.switchTo().activeElement().sendKeys(Keys.TAB);

		}  
	}


	public boolean isAlertPresent(WebDriver driver, int time) {
		try{
			WebDriverWait wt= new  WebDriverWait(driver, Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}

	

	public void sendkeysByJs(WebDriver driver,String text,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].value='text'", element);
	}



	public static void selectOptionFromdropdown(WebElement element,String value) {
		Select s1=new Select(element);       // this generic method is used to select option from dropdown
		List<WebElement> alloptions=s1.getOptions();
		for(WebElement option:alloptions) {
			if(option.getText().equals(value)) 
			{
				option.click();
				break; 
			}
		}
	}
	public  void captureScreenshot(WebDriver driver, String filename) throws IOException {

		TakesScreenshot ts= (TakesScreenshot) driver;
		File fileobj =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileobj,new File("./LogScreenshots/"+filename));
	}
public WebElement applyFluentWait(WebDriver driver,By locator,int atime,int ptime) {
	
	Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
			  .withTimeout(Duration.ofSeconds(atime))
			  .pollingEvery(Duration.ofSeconds(ptime))
			  .ignoring(NoSuchElementException.class); 

			WebElement getEle = Fwait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
			    return driver.findElement(locator);
			  }
			});
			return getEle;
}  
public  WebElement visibilityOfWebelementBylocator(WebDriver driver, By locator,int time) {
	WebDriverWait applyWait=new WebDriverWait(driver, Duration.ofSeconds(time));
	WebElement ele= applyWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	//WebElement element = driver.findElement(locator);
	return ele ;//this method use to apply explicit wait on any element
}
	
	public WebElement waitForElementPresent(WebDriver driver,int time,By locator) {
		WebDriverWait applyWait=new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement ele= applyWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    return ele;
	}
}
