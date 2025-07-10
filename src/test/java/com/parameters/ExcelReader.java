package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
}
