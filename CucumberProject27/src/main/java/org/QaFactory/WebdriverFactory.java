package org.QaFactory;
//17 jun class
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverFactory {
	public static ThreadLocal<WebDriver> TlDriver=new ThreadLocal<WebDriver>();
	public static WebDriver newStartUp(String browserName) {

		 // return type of this method is WebDriver
			// refrence which is here driver

			 // here we declare the refrence of interface

			if(browserName.equalsIgnoreCase("CH")|| browserName.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();

				//driver=new ChromeDriver();
				TlDriver.set(new ChromeDriver());
			} 

			else if(browserName.equalsIgnoreCase("ff")|| browserName.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();

		 		//driver=new FirefoxDriver();
				TlDriver.set(new FirefoxDriver());
		  	}
			else if(browserName.equalsIgnoreCase("ed")|| browserName.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				//driver=new EdgeDriver();//upcasting EdgeDriver memory in WebDriver class
				TlDriver.set(new EdgeDriver());
			} 
			else {
				System.out.println("invalid browser name");
			}
			getDriver().manage().window().maximize();
			//manage().window().maximize();//it will maximize the browser
			//driver.manage().window().setSize(new Dimension(300,300));// it will open browser and set the size of browser 
			// in given dimension
			
			return getDriver();
			 
	}
	
	
	
public static synchronized WebDriver getDriver() {
	return TlDriver.get();
	
}	
}