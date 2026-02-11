package com.qa.utill;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {
	
	public static Object[][] getExcelData(String path, String Sheetname) throws IOException{
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(Sheetname);
		
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		
		
		Object[][] data = new Object[row-1][col];
		
		for(int i =1; i< row;i++) {
			for (int j =0; j < col ; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		fis.close();
		//workbook.close();
		
		return data;
	}
	
}
