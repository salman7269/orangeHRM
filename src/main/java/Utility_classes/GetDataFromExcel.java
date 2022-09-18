package Utility_classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	
	public static String getdata(int row, int cell) throws IOException
	{
		FileInputStream file= new FileInputStream("D:\\orangehrm.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		 Sheet sheet = workbook.getSheet("Sheet1");
		String value=sheet.getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
	}
	
	public static String get_SwagLabs_data(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\swaglabs.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		String value=sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	public static String get_Facebook_Data(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\Facebook.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		String String_value=sheet.getRow(row).getCell(cell).getStringCellValue();
		
		return String_value;
	}
	public static int get_Facebook_Data2(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\Facebook.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int Integer_value=(int) sheet.getRow(row).getCell(cell).getNumericCellValue();
		
		return Integer_value;
	}
	
	
	
	
		
}
