package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericUtils;

public class WebTableRegistrationPage {

	public WebDriver driver;
	public GenericUtils genericutils;

	public WebTableRegistrationPage(WebDriver driver, GenericUtils genericutils) {
		this.driver = driver;
		this.genericutils = genericutils;
	}

	private By webtable = By.xpath("//span[text()='Web Tables']");
	private By row = By.xpath("//div[@class='rt-tr-group']");
	private By add = By.cssSelector("#addNewRecordButton");
	private By firstname = By.cssSelector("#firstName");
	private By lastname = By.cssSelector("#lastName");
	private By useremail = By.cssSelector("#userEmail");
	private By age = By.cssSelector("#age");
	private By regsalary = By.cssSelector("#salary");
	private By regdepartment = By.cssSelector("#department");
	private By submitbutton = By.cssSelector("#submit");
	private By editbutton = By.cssSelector("span[id='edit-record-3'] svg");
	
	

	public void clickwebtable() {
		driver.findElement(webtable).click();

	}

	public void addRegistrationform() {
		driver.findElement(add).click();
	

	}
	
	public void fillthewebtabledata(String fname, String lname,String email,int ages,int salary,String department) {

		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(useremail).sendKeys(email);
		driver.findElement(age).sendKeys(String.valueOf(ages));
		driver.findElement(regsalary).sendKeys(String.valueOf(salary));
		driver.findElement(regdepartment).sendKeys(department);
		WebElement ele=driver.findElement(submitbutton);
		genericutils.clickonelement(ele);

		
		
	}

	public void clickEditIfFirstNameExists(String firstNameToSearch) {
		// Locate all rows in the web table body   
		List<WebElement> rows = driver.findElements(row);

		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.xpath(".//div[@class='rt-td']"));

		    if (cells.size()>0) {  // Ensure row has enough cells
		        String firstName = cells.get(0).getText();
		        String lastName = cells.get(1).getText();
		        String age = cells.get(2).getText();
		        String email = cells.get(3).getText();
		        String salary = cells.get(4).getText();
		        String department = cells.get(5).getText();

		        // Example check
		        if (firstName.equalsIgnoreCase("Spiderman")) {
		            System.out.println("Row matched for spiderman");
		            System.out.println("Full Data: " + firstName + ", " + lastName + ", " + age + ", " + email + ", " + salary + ", " + department);
break;
		            // Assert or compare with expected data
		        }
		    }
		}


		System.out.println("First name not found in the table: " + firstNameToSearch);

	}
	
	public void editbutton()
	{
		driver.findElement(editbutton).click();
	}
}
