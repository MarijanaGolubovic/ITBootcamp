package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objects.HomePage;
import objects.LogInPage;
import utility.Constants;

public class LogInPageTest {

	private static WebDriver driver;

	@BeforeClass

	public void createDriver() {
		System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
	}

	@AfterClass

	public void closeDriver() {
		driver.quit();
	}

	@Test

	public void loginTest() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		HomePage.openHomePage(driver);
		HomePage.clickLogin(driver);
		LogInPage.logInUser(driver);

		wait.until(ExpectedConditions.urlToBe(Constants.HUMANITY_URL));

		String expectedUrl = Constants.HUMANITY_URL;
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}
}
