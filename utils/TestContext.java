package utils;

import org.openqa.selenium.WebDriver;

import pageObject.PageObjectManager;

public class TestContext {

	public TestBase testbase;
	public PageObjectManager pageobjectmanager;
	public GenericUtils genericutils;
	private WebDriver driver;

	public TestContext() {

		testbase = new TestBase();
		driver = testbase.WebDriverManager();
		genericutils = new GenericUtils(driver);
		pageobjectmanager = new PageObjectManager(driver, genericutils);

	}

	public WebDriver getDriver() {
		return driver;
	}

}
