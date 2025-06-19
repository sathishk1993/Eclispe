package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericUtils;

public class ButtonPage {

	public WebDriver driver;
	GenericUtils genericutils;

	private By buttontab = By.xpath("//span[contains(text(),'Buttons')]");
	private By doubleclick = By.cssSelector("#doubleClickBtn");
	private By rightbutton = By.cssSelector("#rightClickBtn");
	private By doubleClickMessage = By.cssSelector("#doubleClickMessage");

	public ButtonPage(WebDriver driver, GenericUtils genericutils) {
		this.driver = driver;
		this.genericutils = genericutils;
	}

	public void navigateToElementPage() {
		driver.navigate().to("https://demoqa.com/elements");
		WebElement button = driver.findElement(buttontab);
		genericutils.clickonelement(button);

	}

	public void doubleClickonButton() {
		WebElement element = driver.findElement(doubleclick);
		genericutils.doubleClick(driver, element);

	}

	public void validateDoubleClickMessage() {
		WebElement doubleclickmessage = genericutils.WebDriverwaitonlocator(doubleClickMessage);
		String textmessage = doubleclickmessage.getText();
		Assert.assertEquals(textmessage, "You have done a double click");
	}

	public void rightClickonButton() {
		WebElement rightclick = driver.findElement(rightbutton);
		genericutils.rightClick(driver, rightclick);
	}

}
