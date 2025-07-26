package com.MyTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class D04ReadLoginData {
	String fPath = System.getProperty("user.dir") + "\\MyExcelFiles\\LoginData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	int rows;
	
	public static void main(String[] args) throws IOException {
		D04ReadLoginData d1 = new D04ReadLoginData();
		d1.getLoginData();
	}
	
	@DataProvider
	public String[][] getLoginData() throws IOException
	{
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		
		rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows][2];
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				loginData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		wb.close();
		fis.close();
		
		return loginData;
	}

}
