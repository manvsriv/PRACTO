package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String[] getCred(int sheetNo, int rowNo) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\manvsriv\\OneDrive - Capgemini\\Desktop\\Manager\\demotest1\\src\\test\\resource\\ExcelData\\LoginCred.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheetAt(sheetNo);
		XSSFRow row = sheet.getRow(rowNo);
		XSSFCell cell1 = row.getCell(0); //user
		XSSFCell cell2= row.getCell(1);  //pass
		String[] data = new String[2];
		data[0] = cell1.getStringCellValue();   //user
		data[1] = cell2.getStringCellValue();  //pass

		return data;
	}
	
	
	//for DataTable
	
	public String[] loginReader(String s) throws IOException
	{
		String path = "C:\\Users\\manvsriv\\OneDrive - Capgemini\\Desktop\\Manager\\demotest1\\src\\test\\resource\\ExcelData\\"+s;
        String cred[] = new String[4];

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook work  = new XSSFWorkbook(fis);
        XSSFSheet excel = work.getSheetAt(0);
        cred[0] = excel.getRow(1).getCell(0).getStringCellValue();
        cred[1] = excel.getRow(1).getCell(1).getStringCellValue();
        cred[2]= excel.getRow(2).getCell(0).getStringCellValue();
        cred[3]=excel.getRow(2).getCell(1).getStringCellValue();
        work.close();
        return cred;
	
}
	public int[] surgeryData(String name, String phnumber) throws IOException
	{
		
		String user[]= name.split(""); //10  user[0] = 1 and user[1] = 0
		String[] pass = phnumber.split(""); //11 pass[0]=1 and pass[1] = 1
		int arr[]= new int[4];
	 arr[0] = Integer.parseInt(user[0]);
	  arr[1] = Integer.parseInt(user[1]);
	  arr[2] = Integer.parseInt(pass[0]);
	 arr[3]= Integer.parseInt(pass[1]);
	
	return arr;
	
	
	}
}
