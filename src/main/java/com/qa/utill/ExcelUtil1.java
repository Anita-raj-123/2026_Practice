package com.qa.utill;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

import com.qa.base.BaseTest;

public class ExcelUtil1 extends BaseTest {

	public static Object[][] getExcelData(String path, String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		List<Object[]> dataList = new ArrayList<>(); //We don’t know how many valid rows exist.

		for (int i = 1; i <= rowCount; i++) {

		    XSSFRow row = sheet.getRow(i);

		    if (row == null) {
		        continue;   //skip blank row
		    }

		    boolean isEmpty = true;   //We assume row is empty initially. 


		    Object[] rowData = new Object[colCount]; //Then we check each cell.

		    for (int j = 0; j < colCount; j++) {   //Now we read each cell value.

		        if (row.getCell(j) != null) {
		            row.getCell(j).getCellType();
		            String value = row.getCell(j).getStringCellValue().trim(); //We get cell value.

		            if (!value.isEmpty()) {
		                isEmpty = false;
		            }

		            rowData[j] = value;
		        } else {
		            rowData[j] = "";
		        }
		    }

		    if (!isEmpty) {
		        dataList.add(rowData);
		    }
		}

		//workbook.close();
		fis.close();

		Object[][] data = new Object[dataList.size()][colCount];

		for (int i = 0; i < dataList.size(); i++) {
		    data[i] = dataList.get(i);
		}

		return data;
}}