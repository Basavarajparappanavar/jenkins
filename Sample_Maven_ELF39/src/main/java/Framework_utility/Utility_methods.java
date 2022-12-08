package Framework_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Utility_methods extends Base_Test {
	public static Object[][] get_test_data(String sheetname) throws IOException {
			String filepath="./Test_data/Test_data.xlsx";
			FileInputStream fis=new FileInputStream(filepath);
			//Create object for Excel file
			Workbook book=new XSSFWorkbook(fis);
			//Access the sheet
			Sheet sheet=book.getSheet(sheetname);
			int rowcount=sheet.getPhysicalNumberOfRows();
			int col_count=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(rowcount);
			System.out.println(col_count);
			Object[][] data=new Object[rowcount-1][col_count];
			for(int row=1;row<=rowcount-1;row++) {
				
				for(int col=0;col<=col_count-1;col++) {
				data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
			
				}
				System.out.println();
			}
			return data;
	}
	public static void Enter_value_to_edit_field(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void click_element(WebElement element) {
		element.click();
	}
	public static void select_by_index(WebElement element,int index) {
		Select options=new Select (element);
		options.selectByIndex(index);
		}
	public static void select_by_VisibleText(WebElement element,String value) {
		Select options=new Select (element);
		options.selectByVisibleText(value);
	}
	public static void select_by_value(WebElement element,String value) {
		Select options=new Select (element);
		options.selectByValue(value);
	}
	public static Actions actions(WebElement element) {
		Actions action =new Actions(driver);
		return action;
	}
	public static String Test_configuration() throws IOException {
		String filepath="./Test_configuration/Test_configuration.properties";
		FileInputStream fis=new FileInputStream(filepath);
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("URL");
		return url;
		
	}
		
}
