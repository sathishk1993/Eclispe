package pageObject;

import org.openqa.selenium.WebDriver;

import stepDefinitions.Hooks;
import utils.GenericUtils;

public class PageObjectManager {

	public WebDriver driver;

	GenericUtils genericutils;
	EnrollmentPage enrollmentpage;
	WebTableRegistrationPage webtable;
	Hooks hook;
	ButtonPage buttonPage;

	public PageObjectManager(WebDriver driver, GenericUtils genericutils) {
		this.driver = driver;
		this.genericutils = genericutils;
	}

	public EnrollmentPage getenrollmentpage() {
		enrollmentpage = new EnrollmentPage(driver, genericutils);
		return enrollmentpage;
	}

	public WebTableRegistrationPage getWebTableRegistrationPage() {
		webtable = new WebTableRegistrationPage(driver, genericutils);
		return webtable;
	}
	
	public ButtonPage getButtonPage()
	{
		buttonPage=new ButtonPage(driver,genericutils);
		return buttonPage;
	}

}
