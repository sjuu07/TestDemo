package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook xs;
	public ExcelDataProvider() {
		
		File exc=new File("./testdata/Login.xlsx");
		try {
			FileInputStream fs=new FileInputStream(exc);
			 xs=new XSSFWorkbook(fs);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public String setData(String shtnm,int i,int j) {
		return xs.getSheet(shtnm).getRow(i).getCell(j).getStringCellValue();
		
	}

	
}
