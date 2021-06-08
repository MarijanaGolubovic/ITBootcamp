package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage {

	private static final String EDT_DETAILS = "Edit Details";
	private static final String NICKNAME = "//*[@id=\"nick_name\"]";
	private static final String ADDRESS = "//*[@id=\"address\"]";
	private static final String CITY = "//*[@id=\"city\"]";
	private static final String MOB_PROVIDER_MENU = "//*[@id=\"smsgateway\"]";
	private static final String SAVE_BTN = "update";
	

	public static void openProfilePage(WebDriver driver) {
		HumanityPage.clickProfileMenu(driver);
		HumanityPage.clickProfileLink(driver);
	}

	public static void clickEditDetails(WebDriver driver) {
		driver.findElement(By.linkText(EDT_DETAILS)).click();
	}

	public static WebElement findNicknameField(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(NICKNAME));
		return element;
	}

	public static void inputNickName(WebDriver driver, String input) {
		findNicknameField(driver).clear();
		findNicknameField(driver).sendKeys(input);
	}

	public static WebElement findAddressField(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(ADDRESS));
		return element;
	}

	public static void inputAddress(WebDriver driver, String input) {
		findAddressField(driver).clear();
		findAddressField(driver).sendKeys(input);
	}

	public static WebElement findCityField(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(CITY));
		return element;
	}

	public static void inputCity(WebDriver driver, String input) {
		findCityField(driver).clear();
		findCityField(driver).sendKeys(input);
	}
	
	public static WebElement findProviderMenu(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(MOB_PROVIDER_MENU));
		return element;
	}

	public static void chooseProvider(WebDriver driver, String option) {
		Select se = new Select(driver.findElement(By.name("smsgateway")));
		se.selectByVisibleText(option);
	}

	public static void clickSaveBtn(WebDriver driver) {
		driver.findElement(By.name(SAVE_BTN)).click();
	}

}
