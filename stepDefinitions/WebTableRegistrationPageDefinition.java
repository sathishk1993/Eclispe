package stepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.WebTableRegistrationPage;
import utils.TestContext;

public class WebTableRegistrationPageDefinition {

	WebTableRegistrationPage webtable;
	TestContext testcontext;

	public WebTableRegistrationPageDefinition(TestContext testcontext) {
		this.testcontext = testcontext;
		webtable = testcontext.pageobjectmanager.getWebTableRegistrationPage();

	}

	@Given("User clicks on WebTable")
	public void user_clicks_on_web_table() {

		webtable.clickwebtable();
		webtable.addRegistrationform();
	}

	@When("User clicks on Add button")
	public void user_clicks_on_add_button(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);
		webtable.fillthewebtabledata(data.get("FirstName"), data.get("LastName"), data.get("Email"),
				Integer.parseInt(data.get("Age")), Integer.parseInt(data.get("Salary")), (data.get("Department")));

	}

	@Then("User fills the form and submits")
	public void user_fills_the_form_and_submits() {

		webtable.clickEditIfFirstNameExists("Spiderman");
		webtable.brokenLinkTab();
		webtable.clickBrokenImage();
		webtable.verifythestatuscode();
		webtable.clickhere();

	}

}
