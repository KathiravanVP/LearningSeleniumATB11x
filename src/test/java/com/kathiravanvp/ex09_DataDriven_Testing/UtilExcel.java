package com.kathiravanvp.ex09_DataDriven_Testing;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    static Workbook book;
    static Sheet sheet;

    public static String sheet_path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";


    public static Object[][] getTestDataFromExcel(String sheetname) {

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(sheet_path);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetname);

        } catch (IOException e) {
            System.out.println("Either File Not Found! or workbook not created!");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;
    }
}
