package org.ApplicationHooks;

import java.io.IOException;
import java.util.Properties;

import org.QaFactory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksForLoginpage {

	private	ConfigReader cr;

	public static WebDriver driver; 
//	BaseUtility bu;
	 
	public static Properties prop;
	@Before
	public void getProperties() {
		cr=new ConfigReader();
		prop= cr.initprop();
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 
		//WebdriverFactory dl=new WebdriverFactory();
		
		String	bname=prop.getProperty("browserName");
			String url=prop.getProperty("Actiurl");
	
		
	}
	// note we can use before and after hooks multiple times
	// you need only method name diffrent and you can set order also of execution
	//	@Before(order=2)
	//	public void launchbrowser() {  
	//	
	//		//driver=bu.newStartUp(bname);
	//		
	//		}
	
	@Before // note all hooks by default throw object of Scenario object
	public void takeScrrenshot(Scenario scn) throws IOException {
		if(scn.isFailed()) {//this method call when the scenario will failed
	String name=scn.getName().replaceAll(" ", "");
			
	
			
		}
	}
	@After
	public void teardown() {
		driver.quit();
	}


}
