package org.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseUtility;

public class LoginPage {
	WebDriver driver;
	
	static By HeaderLable=By.id("#headerContainer");
	
	//webelement step 1 of page object module
	//@FindBy(how=How.ID,using="#headerContainer") we also can write like this but not recommend

	@FindBy(css="td[class='header']")
	@CacheLookup
	private WebElement loginHeaderlabel;

	


	@FindBy(css="img[src='/img/default/login/logo.png?hash=1388610907']")
	@CacheLookup
	private WebElement logolable;

	@FindBy(css="img[src='/img/default/login/timer.png?hash=1388610907']")
	@CacheLookup
	private WebElement verifylogo;

	@FindBy(css="input[name='username']")
	@CacheLookup
	private WebElement namefield;

	@FindBy(css="input[name='pwd']")
	@CacheLookup
	private WebElement passwordfield;

	@FindBy(xpath="//input[@type='checkbox']")
	@CacheLookup
	private WebElement logincheckbox;

	@FindBy(css="#loginButton>div")
	@CacheLookup
	private WebElement loginbtn;

	@FindBy(css="a[ href='http://www.actitime.com']")
	@CacheLookup
	private WebElement actitimelink;

	@FindBy(xpath="//a[text()='View License']")
	private WebElement licenselink;

	@FindBy(css="#logoContainer img ")// this method returns you list of webelement this is syntax:1
	private List<WebElement> logos;
	//oR
	@ FindBys(@FindBy(css="#logoContainer img"))// this method returns you list of webelement this is syntax:2
	private List<WebElement> logos1;

	@FindBy(css="span[class='errormsg']")
	private WebElement errormsg;

	//Or findOut multiple webelement with multiple locators // it will return you 
	//	@FindAll ({@FindBy(xpath="//input[@type='checkbox'"),@FindBy(xpath="//input[@type='radiobtn'")})
	//	private List<WebElement> forExampleconsider; 

	// constructor step 2 of poage object model

	public LoginPage(WebDriver driver) { // this constructor is used to initialize the page factory
		//PageFactory.initElements(driver,LoginPage.class);//pagefactory class use to initialize the webelement of this page
		//OR we can write below line also to initialize the webelements
		PageFactory.initElements(driver, this);// this keyword pointing the memory of object and memory contains all webelements of this class
		this.driver=driver;

	}


	// step 3 page action methods of Page Object model

	public boolean headerlabelIsDispalyed() {
		return	loginHeaderlabel.isDisplayed();
		}
	
	public boolean LogolableIsDisplayed() {
		return logolable.isDisplayed();
	}

	public boolean LogoIsDisplayed() {
		return verifylogo.isDisplayed();
	}
	public WebElement UsernameGetvalue() { 
		return namefield;
	}
	
	
	public boolean UsernameFieldIsDisplayed() { 
		return namefield.isDisplayed();
	}

	public boolean PwdFieldIsDisplayed() {
		return passwordfield.isDisplayed();
	}
	public boolean LoginCheckboxIsDisplayed() {
		return logincheckbox.isDisplayed();
	}
	public boolean LoginbtnIsDisplayed(){
		return loginbtn.isDisplayed();
	}
	public WebElement Loginbtn(){
		return loginbtn;
	}

	public boolean ActitimeLinkIsDisplayed(){
		return actitimelink.isDisplayed();
	}

	public boolean LicenseLinkIsDispayed(){
		return licenselink.isDisplayed();
	}
	
	public boolean errormsgIsDisplayed() {
		return errormsg.isDisplayed();
		
	}
	public WebElement errormsg() {
		return errormsg;
		
	}
		
	public void verifyLoginPage() {

		System.out.println(loginHeaderlabel.isDisplayed()); 
		System.out.println("PwdFieldIsDisplayed: "+PwdFieldIsDisplayed());
		System.out.println("UsernameFieldIsDisplaye: "+UsernameFieldIsDisplayed());
		System.out.println("LoginbtnIsDisplayed: "+loginbtn.isDisplayed()); 
		System.out.println("ActitimeLinkIsDisplayed: "+ActitimeLinkIsDisplayed());
		System.out.println("LicenseLinkIsDispayed: "+LicenseLinkIsDispayed());
		System.out.println("LoginCheckboxIsDisplayed: "+LoginCheckboxIsDisplayed());
		System.out.println("LogoIsDisplayed: "+LogoIsDisplayed());
		System.out.println("headerlabelDisplay: "+headerlabelIsDispalyed());
		System.out.println("logolabelIsDispaly: "+LogolableIsDisplayed());

	}
	public void enterUsername(String Uname) {
		namefield.sendKeys(Uname);
	}
	
	public void enterPassword(String pwd) {
		passwordfield.sendKeys(pwd);
	}
	
	public void clickbtn() {
		loginbtn.click();
	}
	public void LoginActitimepage(String uName,String pwd)  {
		namefield.sendKeys(uName);
		passwordfield.sendKeys(pwd);
		loginbtn.click();
		


	}

	



}
