package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basepackage.TestBase;

public class ExcelUtil extends TestBase {
	
	String excelFilePath = System.getProperty("user.dir") + "//dataTest//";
	
	String fileName;
	String sheetName;
	HashMap<String,String> data;
	
	
	public ExcelUtil(String fileName, String sheetName) throws Exception {
		this.fileName = fileName;
		this.sheetName = sheetName;
		data = getDataInHashMap();
	}
	
	public HashMap<String,String> getDataInHashMap() throws Exception {
		
		File dataFile = new File(excelFilePath + fileName + ".xlsx" + "");
		
		FileInputStream fis = new FileInputStream(dataFile);
		
		HashMap<String,String> currentHash = new HashMap<String,String>();
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet currentSheet = workbook.getSheet(sheetName);
		
		XSSFRow headerRow = currentSheet.getRow(0);
		int numOfRows = currentSheet.getLastRowNum() + 1;
		int numOfColmns = headerRow.getLastCellNum();
		
		for (int i=1; i<numOfRows; i++) {
			Row currentRow = currentSheet.getRow(i);
			for(int j=0; j<numOfColmns; j++) {
				Cell currentCell = currentRow.getCell(j);
				
				switch(currentCell.getCellType()) {
				case STRING:
					currentHash.put(headerRow.getCell(j).getStringCellValue() + "-Row" + String.valueOf(i+1), 
							currentCell.getStringCellValue().trim()); //RunFlag-Row1, suraj
					break;
				
				case NUMERIC:
					currentHash.put(headerRow.getCell(j).getStringCellValue() + "-Row" + String.valueOf(i+1), 
							new DataFormatter().formatCellValue(currentCell)); //RunFlag-Row1, 1
					break;
					
				case BLANK:
					currentHash.put(headerRow.getCell(j).getStringCellValue() + "-Row" + String.valueOf(i+1), "");
					break;
					
				default:
					throw new Exception();
				}
			}
		}
		
		workbook.close();
		return currentHash;	
	}
	
	
	public String getData(String colName) {
		
		String methodName = TestBase.testMethodName;
		
		HashMap<String,String> currentHash = data;
		Set<String> keys = currentHash.keySet();
		
		String row = null;
		String value = null;
		
		for (String key : keys) {
			if(currentHash.get(key).equals(methodName)) {
				String[] list = key.split("-"); // check1, Row2
				row = list[1]; // Row4
			}
		}
		
		value = currentHash.get(colName + "-" + row); // RunFlag-Row2
		return value;	
	}
	
	public int getRowNumber() {
		
		String methodName = TestBase.testMethodName;
		
		HashMap<String,String> currentHash = data;
		Set<String> keys = currentHash.keySet();
		
		String row = null;
		
		for (String key : keys) {
			if(currentHash.get(key).equals(methodName)) {
				String[] list = key.split("-"); // check1, Row2
				row = list[1]; // Row4 - 4
			}
		}
		
		row = row.substring(3);
		
		int a = Integer.parseInt(row);  //1 //0
		
		return a;
		
		
	}
	
	public boolean setCellData(String colName, String value) {
		try {
			int rowNum = getRowNumber();
			FileInputStream fis = new FileInputStream(excelFilePath + fileName + ".xlsx" + "");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int colNum = -1;
			
			XSSFRow row = sheet.getRow(0);
			for (int i=0; i<row.getLastCellNum(); i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName)) {
					colNum = i;
				}
			}
			
			sheet.autoSizeColumn(colNum);
			
			row = sheet.getRow(rowNum - 1); // 3-1 = 2
			
			if ( row == null ) {
				row = sheet.createRow(rowNum - 1);
			}
			
			XSSFCell cell = row.getCell(colNum);
			if ( cell == null ) {
				cell = row.createCell(colNum);
			}
			
			cell.setCellValue(value);
			
			FileOutputStream fos = new FileOutputStream(excelFilePath + fileName + ".xlsx" + "");
			workbook.write(fos);
			workbook.close();
			fos.close();

		} catch ( Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	

}