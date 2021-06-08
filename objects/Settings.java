package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Settings {

	public static final String SETTINGS_TITLE = "//*[@id=\"_cd_admin\"]/div[1]/div/div/div[1]/div/div";
	private static final String LANGUAGE = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String EMAIL_CHECK = "pref_pref_email";
	public static final String SMS_CHECK = "pref_pref_sms";
	public static final String MOBILE_CHECK = "pref_pref_mobile_push";
	private static final String SAVE_BTN = "act_primary";

	public static void clickLanguageMenu(WebDriver driver) {
		driver.findElement(By.xpath(LANGUAGE)).click();
	}

	public static void chooseLanguage(WebDriver driver, String option) {

		Select se = new Select(driver.findElement(By.name("language")));
		se.selectByVisibleText(option);
	}
	
	
	public static WebElement findEmailCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.id(EMAIL_CHECK));
		return element;
	}
	
	public static void uncheckEmail(WebDriver driver) {	
		if (findEmailCheckbox(driver).isSelected()) {
			findEmailCheckbox(driver).click();
		}
	}
	
	public static WebElement findSmsCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.id(SMS_CHECK));
		return element;
	}

	public static void uncheckSMS(WebDriver driver) {
		if (findSmsCheckbox(driver).isSelected()) {
			findSmsCheckbox(driver).click();
		}
	}
	
	public static WebElement findMobPushCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.id(MOBILE_CHECK));
		return element;
	}

	public static void uncheckMobPush(WebDriver driver) {
		if (findMobPushCheckbox(driver).isSelected()) {
			findMobPushCheckbox(driver).click();
		}
	}

	public static void clickSaveBtn(WebDriver driver) {
		driver.findElement(By.id(SAVE_BTN)).click();
	}

}
