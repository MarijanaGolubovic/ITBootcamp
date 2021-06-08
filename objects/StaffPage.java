package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaffPage {
		
	private static final String SAVE_BTN = "update";
	private static final String EDT_DETAILS = "Edit Details";  
	private static final String FIRSTNAME = "first_name"; 
	private static final String SAVE_EMPLOYEE = "_as_save_multiple";  
	private static final String UPLOAD_BTN = "fileupload";
	
	private static String GET_FN(int i) {
		return "//*[@id=\"_asf"+ i +"\"]";
	} 
	
	private static String GET_LN(int i) {
		return "//*[@id=\"_asl"+ i +"\"]";
	} 
		
	private static String GET_EMAIL(int i) {
		return "//*[@id=\"_ase"+ i +"\"]";
	} 
	
	public static void inputFirstName(WebDriver driver, String input, int i) {
		driver.findElement(By.xpath(GET_FN(i))).sendKeys(input);
	}

	public static void inputLastName(WebDriver driver, String input, int i) {
		driver.findElement(By.xpath(GET_LN(i))).sendKeys(input);
	}

	public static void inputEmail(WebDriver driver, String input, int i) {
		driver.findElement(By.xpath(GET_EMAIL(i))).sendKeys(input);
	}

	public static void clickSaveBtn(WebDriver driver) {
		driver.findElement(By.name(SAVE_BTN)).click();
	}

	public static void clickEditDetails(WebDriver driver) {
		driver.findElement(By.linkText(EDT_DETAILS)).click();
	}
	
	public static void uploadPhoto(WebDriver driver, String input) {
		driver.findElement(By.id(UPLOAD_BTN)).sendKeys(input);
		clickSaveBtn(driver);
	}

	public static void clickSaveEmployee(WebDriver driver) {
		driver.findElement(By.id(SAVE_EMPLOYEE)).click();
	}
	
	public static void addEmployee(WebDriver driver, String firsN, String lastN, String email) {
		inputFirstName(driver, firsN, 1);
		inputLastName(driver, lastN, 1);
		inputEmail(driver, email, 1);
		clickSaveEmployee(driver);
	}

	public static void chooseEmployee(WebDriver driver, String text) {
		WebElement we = driver.findElement(By.linkText(text));
		we.click();
	}

	public static void changeEmployeeNameTo(WebDriver driver, String name) {
		WebElement nameInputF = driver.findElement(By.id(FIRSTNAME));
		nameInputF.clear();
		nameInputF.sendKeys(name);
		clickSaveBtn(driver);
	}

	
}
