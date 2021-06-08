package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Constants;


public class HumanityPage {
		
	private static final String DASHBOARD = "//*[@id=\"sn_dashboard\"]/span/p";
	private static final String SHIFTPLAN = "ShiftPlanning";
	private static final String TIMECLOCK = "Time Clock";
	private static final String LEAVE = "Leave";
	private static final String TRAINING = "Training";
	private static final String STAFF = "Staff";
	private static final String AVAILABILITY = "Availability";
	private static final String PAYROLL = "Payroll";
	private static final String REPORTS = "Reports";
	private static final String SETTINGS_BTN = "#sn_admin > span > i";
	public static final String PROFILE_MENU = "//*[@id=\"wrap_us_menu\"]/i";
	private static final String PROFILE_BTN = "//*[@id=\"userm\"]/div/a[1]";
	

	public static void openHumanityPage(WebDriver driver) {
		driver.navigate().to(Constants.HUMANITY_URL);
		driver.manage().window().maximize();

	}

	public static void clickDashboard(WebDriver driver) {
		driver.findElement(By.xpath(DASHBOARD)).click();
	}

	public static void clickShiftPlanning(WebDriver driver) {
		driver.findElement(By.linkText(SHIFTPLAN)).click();

	}

	public static void clickTimeClock(WebDriver driver) {
		driver.findElement(By.linkText(TIMECLOCK)).click();
	}

	public static void clickLeave(WebDriver driver) {
		driver.findElement(By.linkText(LEAVE)).click();
	}

	public static void clickTraining(WebDriver driver) {
		driver.findElement(By.linkText(TRAINING)).click();
	}

	public static void clickStaff(WebDriver driver) {
		driver.findElement(By.linkText(STAFF)).click();
	}

	public static void clickAvailability(WebDriver driver) {
		driver.findElement(By.linkText(AVAILABILITY)).click();
	}

	public static void clickPayroll(WebDriver driver) {
		driver.findElement(By.linkText(PAYROLL)).click();
	}

	public static void clickReports(WebDriver driver) {
		driver.findElement(By.linkText(REPORTS)).click();
	}

	public static void clickProfileMenu(WebDriver driver) {
		driver.findElement(By.xpath(PROFILE_MENU)).click();
	}

	public static void clickProfileLink(WebDriver driver) {
		driver.findElement(By.xpath(PROFILE_BTN)).click();
	}
	
	public static void clickSettingsBtn(WebDriver driver) {
		driver.findElement(By.cssSelector(SETTINGS_BTN)).click();		
	}

}
