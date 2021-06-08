package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.HumanityPage;
import objects.LogInPage;
import utility.Constants;

public class HumanityPageTest {

	private static WebDriver driver;

	@BeforeClass

	public void setUp() {
		System.setProperty(Constants.DRIVER, Constants.DRIVER_PATH);
		driver = new ChromeDriver();
		HumanityPage.openHumanityPage(driver);
		LogInPage.logInUser(driver);
	}

	@BeforeMethod

	public void implWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass

	public void closeDriver() {
		driver.quit();
	}

	// Nav elements tests

	@Test(priority = 1)

	public void dashboardTest() {

		HumanityPage.clickDashboard(driver);

		String expectedUrl = Constants.HUMANITY_URL;
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 2)

	public void shiftPlanningTest() {

		HumanityPage.clickShiftPlanning(driver);

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl.contains(
				"https://marijanagolubovic.humanity.com/app/schedule/employee/week/overview/overview/"), true);
	}

	@Test(priority = 3)

	public void timeClockTest() {

		HumanityPage.clickTimeClock(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/app/timeclock/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 4)

	public void leaveTest() {

		HumanityPage.clickLeave(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/app/requests/vacation/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 5)

	public void trainingTest() {

		HumanityPage.clickTraining(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/app/training/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 6)

	public void staffTest() {

		HumanityPage.clickStaff(driver);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String expectedUrl = Constants.STAFF_URL;
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 7)

	public void availabilityTest() {

		HumanityPage.clickAvailability(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/fe/availability/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 8)

	public void payrollTest() {

		HumanityPage.clickPayroll(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/app/payroll/scheduled-hours/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 9)

	public void reportsTest() {

		HumanityPage.clickReports(driver);

		String expectedUrl = "https://marijanagolubovic.humanity.com/app/reports/dashboard/";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}
}
