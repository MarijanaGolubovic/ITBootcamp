package utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import objects.StaffPage;

public class ExcelUtils {
	
	private static XSSFWorkbook wb;
	private static Sheet sheet;
	private static Cell cell;

	public static void addMultipleEmployees(WebDriver driver)  {

		File f = new File(Constants.XLSX_FILE_PATH);
		try {
			InputStream in = new FileInputStream(f);
			wb = new XSSFWorkbook(in);
			sheet = wb.getSheetAt(0);	
			
			for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);

				String firstName = c0.toString();
				String lastName = c1.toString();
				String email = c2.toString();
								
				StaffPage.inputFirstName(driver, firstName,i+1);
				StaffPage.inputLastName(driver, lastName,i+1);
				StaffPage.inputEmail(driver, email, i+1);
				
			}
			StaffPage.clickSaveEmployee(driver);
			wb.close();	

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static String getCellData(int rowNum, int colNum) {
		
		try {
			cell = sheet.getRow(rowNum).getCell(colNum); 
			String cellData = cell.toString();			
			return cellData;
		
		} catch (Exception e) {
			return "";
		}		
	}
	
	public static int getLastRowNum() {
						
		int lastRowNum = sheet.getLastRowNum() + 1;
		return lastRowNum;
	}
	

}
