package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import objects.HomePage;
import utility.Constants;

public class HomePageTest {

	private static WebDriver driver;

	@BeforeClass

	public void createDriver() {
		System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH);
		;
		driver = new ChromeDriver();
	}

	@AfterClass

	public void closeDriver() {
		driver.quit();
	}

	@Test

	public void aboutPageScrShotTest() throws Exception {

		HomePage.openHomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage.clickAboutUs(driver);
		HomePage.clickAboutUsLink(driver);

		String expectedUrl = Constants.ABOUT_URL;
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.equals(expectedUrl)) {
			HomePage.takeScreenShot(driver, Constants.SSHOT_FILE_PATH);
		}
	}
}
