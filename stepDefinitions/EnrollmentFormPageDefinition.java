package stepDefinitions;


import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.EnrollmentPage;
import utils.TestContext;

public class EnrollmentFormPageDefinition {
	TestContext testcontext;
	EnrollmentPage enrollmentpage;
	
	public EnrollmentFormPageDefinition(TestContext testcontext)
	{
		this.testcontext=testcontext;
		enrollmentpage= testcontext.pageobjectmanager.getenrollmentpage();
	}

	@Given("User clicks on the enrollment form")
	public void user_clicks_on_the_enrollment_form() {
		enrollmentpage.clickondemosite();
		enrollmentpage.elementpage();
		
	    
	}
	@When("User enters the following details:")
	public void user_enters_the_following_details(DataTable dataTable) {
		enrollmentpage.clickonTextbox();
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		enrollmentpage.enterthefullname(data.get("FullName"), data.get("Email"), data.get("CurrentAddress"), data.get("PermanentAddress"));
		
		
	}
	@Then("User submits the enrollment form")
	public void user_submits_the_enrollment_form() {
		
		System.out.println("Enrollment is success");
	   
	}

}
