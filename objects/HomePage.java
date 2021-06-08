package objects;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	private static final String HOME_URL = "https://www.humanity.com/";
	private static final String ABOUT_US_BTN = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	private static final String ABOUT_US_LINK = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	private static final String LOGIN_BTN = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	private static final String CLOSE_POPUP_BTN = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
	private static final String CLOSE_COOKIES_BTN = "//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[1]/button";
	
		
	public static void clickAboutUs(WebDriver driver) {
		driver.findElement(By.xpath(ABOUT_US_BTN)).click();
	}
	
	public static void clickAboutUsLink(WebDriver driver) {
		driver.findElement(By.xpath(ABOUT_US_LINK)).click();
	}
	
	public static void clickLogin(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_BTN)).click();
	}
	
	private static void closePopupWindow(WebDriver driver) {
		driver.findElement(By.xpath(CLOSE_POPUP_BTN)).click();
	}
	
	private static void closeCookies(WebDriver driver) {
		driver.findElement(By.xpath(CLOSE_COOKIES_BTN)).click();
	}
	
	public static void openHomePage(WebDriver driver) {

		driver.navigate().to(HOME_URL);

		driver.manage().window().maximize();

		HomePage.closePopupWindow(driver);

		HomePage.closeCookies(driver);
	
	}
	
	public static void takeScreenShot(WebDriver driver, String fileWithPath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(fileWithPath);

		FileUtils.copyFile(srcFile, destFile);

	}

}
