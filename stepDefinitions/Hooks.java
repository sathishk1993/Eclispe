package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.GenericUtils;
import utils.TestContext;

public class Hooks {

	TestContext testcontext;
	WebDriver driver;

	public Hooks(TestContext testcontext) {
		this.testcontext = testcontext;
		this.driver = testcontext.getDriver();

	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = testcontext.genericutils.takeScreenshotAsBytes(driver);
				scenario.attach(screenshot, "image/png", "Failure Screenshot");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
