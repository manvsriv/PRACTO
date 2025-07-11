package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public String provideLoginData(String symptoms) {

        String path = "C:\\Users\\lkadadas\\Desktop\\Sprint\\Practo\\src\\test\\resource\\Exceldata\\ConsultationForm.xlsx";
        String[] user = symptoms.split("");

        int symptomsRow = Integer.parseInt(user[0]);
        int symptomsCell = Integer.parseInt(user[1]);

        String data = "";

        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            Sheet excel = workbook.getSheetAt(0);

            Cell cell = excel.getRow(symptomsRow).getCell(symptomsCell);

            if (cell.getCellType() == CellType.STRING) {
                data = cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                data = String.valueOf((long) cell.getNumericCellValue());
            } else {
                data = cell.toString();
            }

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
    
  
/*----------------------------------------------------Scenario VI ----------------------------------------------          */
    public static List<List<String>> readExcelData(String filePath) {
        List<List<String>> data = new ArrayList<>();
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        DataFormatter formatter = new DataFormatter();

        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                List<String> rowData = new ArrayList<>();
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        Cell cell = row.getCell(j);
                        String cellValue = (cell != null) ? formatter.formatCellValue(cell) : "";
                        rowData.add(cellValue);
                    }
                }
                data.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    
 

}
