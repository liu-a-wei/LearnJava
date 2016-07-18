package com.liuawei.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class importExcel {
	
	public static void main(String[] args) throws IOException{
		
		String path = "";
		InputStream in = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			HSSFSheet sheet = workbook.getSheetAt(i);
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				HSSFRow row = sheet.getRow(rowNum);
				String docPhone1 = row.getCell(1).getStringCellValue();
				String amount1 = row.getCell(2).getStringCellValue();
				String docPhone2 = row.getCell(4).getStringCellValue();
				String amount2 = row.getCell(5).getStringCellValue();
				if(docPhone1.equals(docPhone2)){
					if(amount1.equals(amount2)){
						
					}else{
						
					}
				}
				
			}
		}
	}
	
}
