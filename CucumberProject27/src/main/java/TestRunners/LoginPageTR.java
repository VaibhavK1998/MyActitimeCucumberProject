package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features={"src/test/resources/featureFiles/verifyloginPage.feature"},
		
	glue={"stepDefinations","org.ApplicationHooks"},
	
	//dryRun=true,
			
	//monochrome=true,
	plugin= {"pretty",
       "junit:target/JunitReport/JunitReport.xml",
		"json:target/JsonReport/JsonReport.json",
		"html:target/HtmlReport/HtmlReport.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
	}
)

public class LoginPageTR {

	
}
