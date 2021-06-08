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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.HumanityPage;
import objects.LogInPage;
import objects.StaffPage;
import utility.Constants;
import utility.ExcelUtils;

public class StaffPageTest {

	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeClass

	public void setUp() {
		System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
		HumanityPage.openHumanityPage(driver);
		LogInPage.logInUser(driver);
	}

	@BeforeMethod

	public void openStaffPage() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HumanityPage.clickStaff(driver);
	}

	@AfterClass

	public void closeDriver() {
		driver.quit();
	}

	@Test

	public void addOneEmployeeTest() {

		driver.navigate().to(Constants.ADD_EMPLOYEES_URL);

		StaffPage.addEmployee(driver, "Milan", "Milanovic", "milan.milanovic123@gmail.com");

		driver.navigate().to(Constants.STAFF_URL);

		boolean expectedRes = true;
		boolean actualRes = driver.getPageSource().contains("milan.milanovic123@gmail.com");

		Assert.assertEquals(actualRes, expectedRes);
	}

	@Test

	public void changeEmployeeNameTest() {

		StaffPage.chooseEmployee(driver, "Milan Milanovic");
		StaffPage.clickEditDetails(driver);
		StaffPage.changeEmployeeNameTo(driver, "Jovan");

		driver.navigate().to(Constants.STAFF_URL);

		wait = new WebDriverWait(driver, 5);

		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Jovan")));

		String expectedResult = "Jovan Milanovic";

		Assert.assertEquals(result.getText(), expectedResult);
	}

	@Test

	public void uploadPictureTest() {

		StaffPage.chooseEmployee(driver, "Jovan Milanovic");
		StaffPage.clickEditDetails(driver);
		StaffPage.uploadPhoto(driver, Constants.PROFILE_PHOTO_PATH);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_status")));
	}

	@Test

	public void addMultipleEmployeesTest() {

		driver.navigate().to(Constants.ADD_EMPLOYEES_URL);

		ExcelUtils.addMultipleEmployees(driver);

		driver.navigate().to(Constants.STAFF_URL);

		SoftAssert sa = new SoftAssert();

		for (int i = 0; i < ExcelUtils.getLastRowNum(); i++) {
			String email = ExcelUtils.getCellData(i, 2);
			boolean result = driver.getPageSource().contains(email);

			sa.assertEquals(result, true);
		}
		sa.assertAll();
	}
}
