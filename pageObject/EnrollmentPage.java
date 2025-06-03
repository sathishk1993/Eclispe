package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.GenericUtils;

public class EnrollmentPage {

	public WebDriver driver;
	GenericUtils genericutils;
	

	private By Demosite = By.xpath("//ul[@class='navbar__links d-none d-lg-flex']//a[normalize-space()='Demo Site']");
	private By Element = By.xpath("//h5[text()='Elements']");
	private By textbox = By.xpath("//span[normalize-space()='Text Box']");
	private By fullname = By.cssSelector("#userName");
	private By useremail = By.cssSelector("#userEmail");
	private By currentaddress = By.cssSelector("#currentAddress");
	private By permanentaddress = By.cssSelector("#permanentAddress");
	private By submit = By.cssSelector("#submit");
	

	
	
	public EnrollmentPage(WebDriver driver, GenericUtils genericutils) {
		this.driver = driver;
		this.genericutils = genericutils;
		
	}

	public void clickondemosite() {
		genericutils.WebDriverwaitonlocator(Demosite);
		driver.findElement(Demosite).click();
		
		
	}

	public void elementpage() {
		genericutils.switchTowindows();
		WebElement element = driver.findElement(Element);
		genericutils.clickonelement(element);

	}

	public void clickonTextbox() {
		WebElement textname = driver.findElement(textbox);
		genericutils.clickonelement(textname);
		driver.findElement(textbox).click();
	}

	public void enterthefullname(String name, String email, String address, String permanentadd) {
		driver.findElement(fullname).sendKeys(name);
		driver.findElement(useremail).sendKeys(email);
		driver.findElement(currentaddress).sendKeys(address);
		driver.findElement(permanentaddress).sendKeys(permanentadd);
		WebElement submitbutton=driver.findElement(submit);
		genericutils.hoverOverElement(submitbutton);
		

	}
	
	

	
 
}
 
