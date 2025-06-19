package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ButtonPage;
import utils.TestContext;

public class ButtonPageStepDefinitionFile {
	
	TestContext testcontext;
	ButtonPage buttonPage;

	public ButtonPageStepDefinitionFile(TestContext testcontext) {
		this.testcontext = testcontext;
		buttonPage = testcontext.pageobjectmanager.getButtonPage();
	
	}
	@Given("User clicks on the button tab")
	public void user_clicks_on_the_button_tab() {
	   buttonPage.navigateToElementPage(); 
	}
	@When("User double-clicks the button")
	public void user_double_clicks_the_button() {
	  buttonPage.doubleClickonButton();
	  buttonPage.validateDoubleClickMessage();
	}
	@Then("User right-clicks the button")
	public void user_right_clicks_the_button() {
	  buttonPage.rightClickonButton();
	}
	@Then("User clicks the button")
	public void user_clicks_the_button() {
	   
	}
}
