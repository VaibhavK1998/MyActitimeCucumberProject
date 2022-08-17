package stepDefinations;

import java.util.List;

import org.ApplicationHooks.HooksForLoginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {
	
	WebDriver driver;
	private LoginPage Lp=new LoginPage(driver);
	@Given("open a browser")
	public void open_a_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  driver.get("http://localhost:85/login.do");
	}
	@When("user enter username and password")
//	public void user_enter_username_and_password(DataTable credentials) {
//		//List<List<String>> data2=  credentials.raw();if ths]is raw method not showing then use below method for 
//		// List<String> data1=credentials.asList();// data table to get data
//		 List<List<String>> data2=  credentials.cells();
//		 Lp.enterUsername(data2.get(0).get(0));
//		Lp.enterPassword(data2.get(0).get(1));
//	}
	@When("click on login button")
	public void click_on_login_button() {
	    Lp.clickbtn();
	}
	@Then("dashboar page titile should be displayed as {string}")
	public void dashboar_page_titile_should_be_displayed_as(String string) {
	    
	}


	
	

}
