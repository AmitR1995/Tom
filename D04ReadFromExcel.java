package com.MyTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D04ReadFromExcel {
	String fPath = System.getProperty("user.dir") + "\\MyExcelFiles\\MyFirst.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void readData() {
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}

}
