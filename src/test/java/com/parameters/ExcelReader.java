package com.parameters;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String[] getCred(int sheetNo, int rowNo) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\ExcelData\\PractoCred1.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheetAt(sheetNo);
		XSSFRow row = sheet.getRow(rowNo);
		XSSFCell cell1 = row.getCell(0); //user
		XSSFCell cell2= row.getCell(1);  //pass
		String[] data = new String[2];
//		data[0] = cell1.getStringCellValue();   //user
//		data[1] = cell2.getStringCellValue();  //pass

		DataFormatter formatter = new DataFormatter();

		data[0] = formatter.formatCellValue(cell1);
		data[1] = formatter.formatCellValue(cell2);

		return data;
	}
	
	
	//for DataTable
	
	public String[] loginReader(String s) throws IOException
	{
		String path = "C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\ExcelData\\"+s;
        String cred[] = new String[2];

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook work  = new XSSFWorkbook(fis);
        XSSFSheet excel = work.getSheetAt(0);
        
        DataFormatter formatter = new DataFormatter();
        cred[0] = formatter.formatCellValue(excel.getRow(1).getCell(0));
        cred[1] = formatter.formatCellValue(excel.getRow(1).getCell(1));

        work.close();
        return cred;
        
	
}
	public String[] provideData(int[]arr) throws IOException, InterruptedException, AWTException
	{
		String path = "C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\ExcelData\\PractoCred1.xlsx";

	
	FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet excel =  workbook.getSheetAt(0);
	
//	enterData(excel.getRow(userRow).getCell(userCell).getStringCellValue(),
//			      excel.getRow(passRow).getCell(passCell).getStringCellValue());
	
	DataFormatter formatter = new DataFormatter();

	String credentials[] = new String[2];
	
	  credentials[0] = formatter.formatCellValue(excel.getRow(arr[0]).getCell(arr[1]));
	credentials[1] = formatter.formatCellValue(excel.getRow(arr[2]).getCell(arr[3]));

	workbook.close();
	return credentials;

	
	}

}
