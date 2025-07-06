package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String[] provideLoginData(String username, String password) {
	    String path = "C:\\Users\\SDHINDLE\\Desktop\\PRACTO\\Sprint\\PractoTesting\\src\\test\\resource\\Exceldata\\LabTestData.xlsx";
	    String user[] = username.split("");
	    String pass[] = password.split("");

	    int userRow = Integer.parseInt(user[0]);
	    int userCell = Integer.parseInt(user[1]);

	    int passRow = Integer.parseInt(pass[0]);
	    int passCell = Integer.parseInt(pass[1]);

	    String[] data = new String[2];
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;

	    try {
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        Sheet excel = workbook.getSheetAt(0);
	        data[0] = excel.getRow(userRow).getCell(userCell).getStringCellValue();
	        data[1] = excel.getRow(passRow).getCell(passCell).getStringCellValue();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (fis != null) {
	                fis.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return data;
	}

	public String provideTestName(String testName) {
	    String path = "C:\\Users\\SDHINDLE\\Desktop\\PRACTO\\Sprint\\PractoTesting\\src\\test\\resource\\Exceldata\\LabTestData.xlsx";
	    String[] test = testName.split("");

	    int testRow = Integer.parseInt(test[0]);
	    int testCell = Integer.parseInt(test[1]);

	    String data = null;
	    FileInputStream fis = null;
	    XSSFWorkbook workbook = null;

	    try {
	        fis = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fis);
	        Sheet excel = workbook.getSheetAt(0);
	        data = excel.getRow(testRow).getCell(testCell).getStringCellValue();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (workbook != null) {
	                workbook.close();
	            }
	            if (fis != null) {
	                fis.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    return data;
	}

}
