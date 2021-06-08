package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.HumanityPage;
import objects.LogInPage;
import objects.ProfilePage;
import utility.Constants;

public class ProfilePageTest {

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
	
		
	@Test(priority = 1)

	public void inputNicknameTest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HumanityPage.PROFILE_MENU)));
		ProfilePage.openProfilePage(driver);
		ProfilePage.clickEditDetails(driver);
		ProfilePage.inputNickName(driver, Constants.NICKNAME);	
	}
	
	@Test (priority = 2)

	public void inputAddressTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		ProfilePage.inputAddress(driver, Constants.ADDRESS);		
	}
	
	@Test(priority = 3)

	public void inputCityTest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ProfilePage.inputCity(driver, Constants.CITY);			
	}
	
	@Test(priority = 4)

	public void chooseProviderTest()  {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		ProfilePage.chooseProvider( driver, "Nextel"); 		
		ProfilePage.clickSaveBtn(driver);		
	}

}
