package utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils genericutils;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchTowindows() {

		String parentwindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String childwindow = it.next();

			if (!parentwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);

			}

		}

	}

	public void hoverOverElement(WebElement ele) {

		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	public void selection(WebElement ele, String name) {
		Select select = new Select(ele);
		select.selectByVisibleText(name);

	}

	public void alertMessageaccept() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertMessageDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void WebDriverwaitonelement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click(); // Optional: click after wait
	}

	public WebElement WebDriverwaitonlocator(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void waitForPageToLoad() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

	}

	public void scrollToElement(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	}

	public WebElement clickonelement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver; // directly clicks
		js.executeScript("arguments[0].click();", element);
		return element;
	}

	public byte[] takeScreenshotAsBytes(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void saveScreenshotToFile(WebDriver driver, String fileName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/" + fileName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void brokenimagetest() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + allLinks.size());

		int brokenCount = 0;

		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");

			try {
				URL linkUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();

				if (responseCode != 200) {
					System.out.println("❌ Broken: " + url + " | Status: " + responseCode);
					brokenCount++;
				} else {
					System.out.println("✅ Valid: " + url + " | Status: " + responseCode);
				}

			} catch (Exception e) {
				System.out.println("⚠️ Error checking: " + url + " | " + e.getMessage());
				brokenCount++;
			}
		}

		System.out.println("🔎 Total broken links found: " + brokenCount);
		driver.quit();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	

}
