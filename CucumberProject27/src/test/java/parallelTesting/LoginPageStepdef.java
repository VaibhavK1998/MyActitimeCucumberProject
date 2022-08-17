package parallelTesting;

import org.ApplicationHooks.HooksForLoginpage;
import org.QaFactory.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageStepdef  {

	//private WebDriver driver;
  private SoftAssert Assert=new SoftAssert();
 HooksForLoginpage hook;
 
	private LoginPage Lp=new LoginPage(HooksForLoginpage.driver);
 
	@Given("User is on login page")
	public void user_is_on_login_page() {// this below line  is used for launch url 
		
		HooksForLoginpage.driver.get(HooksForLoginpage.prop.getProperty("Actiurl"));
         System.out.println(" Given method call");
        
        
	}

	@Then("Username field should be display")
	public void username_field_should_be_display() {
		//System.out.println("UsernameFieldIsDisplaye: "+Lp.UsernameFieldIsDisplayed());
		Assert.assertTrue(Lp.UsernameFieldIsDisplayed(), ": UsernameFieldIsDisplaye");
	}

	@Then("Password field should be dispay")
	public void password_field_should_be_dispay() {
	System.out.println("PwdFieldIsDisplayed: "+Lp.PwdFieldIsDisplayed());
	Assert.assertTrue(Lp.PwdFieldIsDisplayed(), "passwordfielddisplay");
	}

	@Then("Login field should be display")
	public void login_field_should_be_display() { 
		System.out.println("LoginbtnIsDisplayed: "+Lp.LoginbtnIsDisplayed());
	
	}

	@Then("Keep me login checkbox should be display")
	public void keep_me_login_checkbox_should_be_display() {
		System.out.println("LoginCheckboxIsDisplayed: "+Lp.LoginCheckboxIsDisplayed());
		Assert.assertTrue(Lp.LoginCheckboxIsDisplayed(), "LoginCheckboxIsDisplayed");
	} 

	@Then("Logo should be display")
	public void logo_should_be_display() {
		System.out.println("LogoIsDisplayed: "+Lp.LogoIsDisplayed());
		Assert.assertTrue(Lp.LogoIsDisplayed(), "LogoIsDisplayed");
	}

	@Then("Logolabel should be display")
	public void logolabel_should_be_display() {
		System.out.println("logolabelIsDispaly: "+Lp.LogolableIsDisplayed());
		Assert.assertTrue(Lp.LogolableIsDisplayed(), "LogolableIsDisplayed");
	}

	@Then("Header label should be display")
	public void header_label_should_be_display() {
		System.out.println("headerlabelDisplay: "+Lp.headerlabelIsDispalyed());

		Assert.assertTrue(Lp.headerlabelIsDispalyed(), "headerlabelIsDispalyed");
	}

	@Then("Actitime link should be display")
	public void actitime_link_should_be_display() {
		System.out.println("ActitimeLinkIsDisplayed: "+Lp.ActitimeLinkIsDisplayed());
		Assert.assertTrue(Lp.ActitimeLinkIsDisplayed(), "ActitimeLinkIsDisplayed");
	}

	@Then("Licence link should be display")
	public void licence_link_should_be_display() {
		System.out.println("LicenseLinkIsDispayed: "+Lp.LicenseLinkIsDispayed());
		Assert.assertTrue(Lp.LicenseLinkIsDispayed(), "LicenseLinkIsDispayed");
	}
 
	@When("User enter username as {string}")
	public void user_enter_username_as(String uname) throws InterruptedException {
		Thread.sleep(5000);
	   //Lp.enterUsername(HooksForLoginpage.prop.getProperty("ActiUserName"));
		//Lp.enterUsername(HooksForLoginpage.prop.getProperty("ActiUserName"));
	Lp.enterUsername(uname);
		System.out.println("usename enter succesfully");
		//Thread.sleep(5000);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String pwd) throws InterruptedException {
		Lp.enterPassword(pwd);
	//Lp.enterPassword(HooksForLoginpage.prop.getProperty("ActiPassword"));  
	System.out.println("password enter succesfull");
	//Thread.sleep(5000);
	}

	@When("Click login button")
	public void click_login_button() throws InterruptedException {
	    Lp.clickbtn();
	    System.out.println("login btn click succesfully");
	    Thread.sleep(1000);
	}

	

	@Then("Dashboard page title sould be display as \"actiTIME - Enter Time-Track")
	public void dashboard_page_title_sould_be_display_as_acti_time_enter_time_track() {
	  
	
		
	}

	@When("User enter username")
	public void user_enter_username() {
	   
	}

	

	@When("User enter password")
	public void user_enter_password() {
	   
	}




	@Then("Enter correct username and password msg should be display")
	public void enter_correct_username_and_password_msg_should_be_display() {
	   
	}

}