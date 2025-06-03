package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
private static WebDriver driver;
	
	public WebDriver WebDriverManager()
	{
		if(driver==null)
		{
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://toolsqa.com/");
		}
		return driver;
	}
	
}

