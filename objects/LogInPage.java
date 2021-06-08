package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constants;


public class LogInPage {
	
	private static final String USERNAME = "email";
	private static final String PASSWORD = "password";
	private static final String LOGIN_BTN = "login";


	public static void inputUsername(WebDriver driver, String input) {
		WebElement element = driver.findElement(By.id(USERNAME));
		element.clear();
		element.sendKeys(input);
	}

	public static void inputPassword(WebDriver driver, String input) {
		WebElement element = driver.findElement(By.id(PASSWORD));
		element.clear();
		element.sendKeys(input);
	}

	public static void clickLoginBtn(WebDriver driver) {
		driver.findElement(By.name(LOGIN_BTN)).click();
	}

	public static void logInUser(WebDriver driver) {
		inputUsername(driver, Constants.USERNAME);
		inputPassword(driver, Constants.PASSWORD);
		clickLoginBtn(driver);
	}

}
