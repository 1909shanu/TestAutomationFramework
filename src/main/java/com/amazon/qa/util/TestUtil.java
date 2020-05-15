package com.amazon.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.qa.basetest.TestBase;
import com.google.common.io.Files;




public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_TIMEOUT =20;
	public static String TestData_Sheet_Path = "/Users/sudhanshukansal/Documents/Java/TestAutomationFramework/src/main/java/com/amazon/qa/testdata/Amazontestdata.xlsx";
	
	static Sheet sheet;
	static Workbook book;
	
	
	public static Object[][] getTestData(String sheetname) {
		FileInputStream file = null;
		
		try{
			file = new FileInputStream(TestData_Sheet_Path);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch(IllegalFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i =0; i < sheet.getLastRowNum(); i++) {
			for (int j=0; j < sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	

}
