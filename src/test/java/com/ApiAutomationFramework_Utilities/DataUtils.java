package com.ApiAutomationFramework_Utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.ApiAutomationFramework_SetUp.BaseTest;

public class DataUtils extends BaseTest{

	@DataProvider(name = "data")
	public Object[][] getData(Method m) {
		
		System.out.println(m.getName());
		String sheetName = m.getName();
		
		int rowCount = excel.getRowCount(sheetName);
		int columnCount = excel.getColumnCount(sheetName);
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
		System.out.println("Rows are : "+rowCount+" Colums are :"+columnCount);
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for(int rowNum = 2; rowNum <= rowCount; rowNum++) {
			for(int colNum = 0; colNum < columnCount; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}			
		}
//		
//		data[0][0] = excel.getCellData(sheetName, 0, 2);
//		data[0][1] = excel.getCellData(sheetName, 1, 2);
//		data[0][2] = excel.getCellData(sheetName, 2, 2);
//		
		return data;
		
		
	}
}
