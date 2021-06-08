package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.HumanityPage;
import objects.LogInPage;
import objects.Settings;
import utility.Constants;

public class SettingsTest {

	private static WebDriver driver;

	@BeforeClass

	public void setUp() {
		System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
		HumanityPage.openHumanityPage(driver);
		LogInPage.logInUser(driver);
	}

	@AfterClass

	public void closeDriver() {
		driver.quit();
	}

	@Test (priority = 2)

	public void changeLanguageTest() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		HumanityPage.clickSettingsBtn(driver);
		Settings.clickLanguageMenu(driver);
		Settings.chooseLanguage(driver, "Italian (machine)");
		Settings.clickSaveBtn(driver);
		
		wait
		.until(ExpectedConditions.presenceOfElementLocated(By.id("_status")));
		
		driver.navigate().to(Constants.SETTINGS_URL); 
	
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Settings.SETTINGS_TITLE)));

		String expectedResult = "Impostazioni";
		String actualResult = element.getText();

		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test (priority = 1)

	public void uncheckNotificationsTest() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		HumanityPage.clickSettingsBtn(driver);
		Settings.uncheckEmail(driver);
		Settings.uncheckSMS(driver);
		Settings.uncheckMobPush(driver);
		Settings.clickSaveBtn(driver);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.STATUS_MSG_ID)));

		WebElement email = Settings.findEmailCheckbox(driver);
		WebElement sms = Settings.findSmsCheckbox(driver);
		WebElement mobile = Settings.findMobPushCheckbox(driver);
			
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(!email.isSelected(), true);
		sa.assertEquals(!sms.isSelected(), true);
		sa.assertEquals(!mobile.isSelected(), true);
	    sa.assertAll();
	}
}
