package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/features",
	    dryRun=false,
	    objectFactory = io.cucumber.picocontainer.PicoFactory.class,
	    glue = "stepDefinitions",
	    //tags="@smokeTest",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-html-report.html",
	        "json:target/cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
	    
	)


//tags="@smoketest", @smoketest and @sanitytest  , "not @Regression, @smoketest or @sanitytest 
public class TestNGRunner extends AbstractTestNGCucumberTests{

}