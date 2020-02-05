package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Excel {

	private File file = null;
	private FileInputStream file_Input_Stream = null;
	private FileOutputStream file_Output_Stream = null;
	private HSSFWorkbook work_Book = null;
	private HSSFSheet work_Sheet = null;
	private HSSFRow row = null;
	private HSSFCell cell = null;
	public String ExcelLocation = null;

	public void excelEvents(String workSheet, String ExcelLocation, String event) throws FileNotFoundException, IOException {
		ExcelLocation = System.getProperty("user.dir")+"/Dump.xls";

		if(this.ExcelLocation==null) ExcelLocation = System.getProperty("user.dir")+"/Dump.xls";
		else ExcelLocation = this.ExcelLocation;
		
		if(event.equals("openFile")) {
			file_Input_Stream = new FileInputStream(ExcelLocation);
			work_Book = new HSSFWorkbook(file_Input_Stream);
			work_Sheet = work_Book.getSheet(workSheet);
			if(work_Sheet==null) work_Sheet = work_Book.createSheet(workSheet);
		} else if(event.equals("closeFile")) {
			file = new File(ExcelLocation);
			file_Output_Stream = new FileOutputStream(file);
			work_Book.write(file_Output_Stream);
			work_Book.close();
			file_Output_Stream.close();
		} else if(event.equals("closeRead")) {
			work_Book.close();
			file_Input_Stream.close();
		}
	}

	//Function to write hash-map values into excel along with keys
	public boolean writeMap(String workSheet, List<Map<String, Object>> cell_Values) throws FileNotFoundException, IOException {
		excelEvents(workSheet, ExcelLocation, "openFile");

		//Migrating hash-map values into array-lists for easier insertion into excel
		ArrayList<String> key = new ArrayList<String>();
		for (Map.Entry<String, Object> mapValue : cell_Values.get(0).entrySet()) {
			key.add(mapValue.getKey());
		}
		
		int noOfRows = work_Sheet.getPhysicalNumberOfRows();
		if(noOfRows < 1) {
			noOfRows = 0;
		}
		if(noOfRows==0) {
			row = work_Sheet.createRow(noOfRows++);
			for(int colIndex = 0 ; colIndex < key.size() ; colIndex++) {
				cell = row.createCell(colIndex);
				cell.setCellValue(key.get(colIndex));
			}
		} else {
			noOfRows++;
		}

		for(int rowIndex = noOfRows ; rowIndex < cell_Values.size()+noOfRows ; rowIndex++) {
			row = work_Sheet.getRow(rowIndex);
			if(row==null) row = work_Sheet.createRow(rowIndex);

			Record:for(int colIndex = 0 ; colIndex < key.size() ; colIndex++) {
				cell = row.createCell(colIndex);
				try {
					cell.setCellValue(cell_Values.get(rowIndex-noOfRows).get(key.get(colIndex)).toString());
				} catch(Exception e) {
					cell.setCellValue("Value missing");
					break Record;
				}
			}
		}
		excelEvents(workSheet, ExcelLocation, "closeFile");
		return true;
	}
	
	//Function to write hash-map values into excel along with keys
	public boolean writeMap(String workSheet, ArrayList<List<String>> cell_Values) throws FileNotFoundException, IOException {
		excelEvents(workSheet, ExcelLocation, "openFile");

		for(int rowIndex = 0 ; rowIndex < cell_Values.size() ; rowIndex++) {
			row = work_Sheet.getRow(rowIndex);
			if(row==null) row = work_Sheet.createRow(rowIndex);

			for(int colIndex = 0 ; colIndex < cell_Values.get(rowIndex).size() ; colIndex++) {
				cell = row.createCell(colIndex);
				try {
					cell.setCellValue(cell_Values.get(rowIndex).get(colIndex));
				} catch(Exception e) {
					cell.setCellValue("Value missing");
				}
			}
		}
		excelEvents(workSheet, ExcelLocation, "closeFile");
		return true;
	}
	
	//Function to write hash-map values into excel along with keys
	public boolean writeMap(String workSheet, String app, List<Map<String, Object>> cell_Values) throws FileNotFoundException, IOException {
		excelEvents(workSheet, ExcelLocation, "openFile");

		//Migrating hash-map values into array-lists for easier insertion into excel
		ArrayList<String> key = new ArrayList<String>();
		for (Map.Entry<String, Object> mapValue : cell_Values.get(0).entrySet()) {
			key.add(mapValue.getKey());
		}
		
		int noOfRows = work_Sheet.getPhysicalNumberOfRows();
		row = work_Sheet.createRow(noOfRows++);
		cell = row.createCell(0);
		cell.setCellValue("Extra record from : "+app);

		for(int rowIndex = noOfRows ; rowIndex < cell_Values.size()+noOfRows ; rowIndex++) {
			row = work_Sheet.getRow(rowIndex);
			if(row==null) row = work_Sheet.createRow(rowIndex);

			Record:for(int colIndex = 0 ; colIndex < key.size() ; colIndex++) {
				cell = row.createCell(colIndex);
				try {
					cell.setCellValue(cell_Values.get(rowIndex-noOfRows).get(key.get(colIndex)).toString());
				} catch(Exception e) {
					cell.setCellValue("Value missing");
					break Record;
				}
			}
		}
		excelEvents(workSheet, ExcelLocation, "closeFile");
		return true;
	}

	public void deleteSheet(String workSheet) throws FileNotFoundException, IOException {
		excelEvents(workSheet, ExcelLocation, "openFile");
		try	{
			int index =  work_Book.getSheetIndex(work_Sheet);
			if(index != -1)   {
				work_Book.removeSheetAt(index);
			}
		} catch (NullPointerException np) 		{
			np.printStackTrace();
		}
		finally {
			excelEvents(workSheet, ExcelLocation, "closeFile");
		}
	}
	
	/*public Map<String, Map<String,Object>> readData(String workSheet) throws IOException {
		excelEvents(workSheet, ExcelLocation, "openFile");
		Map<String, Map<String,Object>> data = new HashMap<String, Map<String,Object>>();
		
		Map<String,Object> map = null;
		String keyValue = null, cellValue = null, keyColumns = null;
		int col = 0;
		
		Properties prop = new Properties();
		prop = Utility.getProperties();
		keyColumns = prop.getProperty("comparisonColumn");
		
		ArrayList<String> key = new ArrayList<String>();
		row = work_Sheet.getRow(0);
		col = row.getLastCellNum();
		for(int index = 0; index < col ; index++) {
			key.add(row.getCell(index).toString());
		}
		
		for(int rowIndex = 1; rowIndex < work_Sheet.getPhysicalNumberOfRows() ; rowIndex++) {
			map = new HashMap<String, Object>();
			keyValue = "";
			row = work_Sheet.getRow(rowIndex);
			for(int colIndex = 0 ; colIndex < col ; colIndex++) {
				try {
					cellValue = row.getCell(colIndex).toString();
				} catch(Exception e) {
					cellValue = "null";
				}
				if(keyColumns.contains(key.get(colIndex))) {
					keyValue = keyValue+","+key.get(colIndex)+"="+cellValue;
				}
				map.put(key.get(colIndex), cellValue);
			}
			keyValue = keyValue.substring(1, keyValue.length());
			data.put(keyValue, map);
		}
		excelEvents(workSheet, ExcelLocation, "closeRead");
		return data;
	}
	
	public String readEmails(String workSheet, String location) throws IOException {
		file_Input_Stream = new FileInputStream(location);
		work_Book = new HSSFWorkbook(file_Input_Stream);
		work_Sheet = work_Book.getSheet(workSheet);
		if(work_Sheet==null) work_Sheet = work_Book.createSheet(workSheet);
		
		String emails = "";
		int totalRows = work_Sheet.getPhysicalNumberOfRows();
		for(int index = 0; index < totalRows ; index++) {
			row = work_Sheet.getRow(index);
			emails = emails + ",'" + row.getCell(0).toString().toLowerCase()+"'";
		}
		emails = emails.substring(1, emails.length());
		
		work_Book.close();
		file_Input_Stream.close();
		return emails;
	}
	
	/*public String readEmails(String workSheet, String location, boolean flag) throws IOException {
		Properties prop = null;
		if(flag) {
			prop = new Properties();
			prop = Utility.getProperties();
		}
		file_Input_Stream = new FileInputStream(location);
		work_Book = new HSSFWorkbook(file_Input_Stream);
		work_Sheet = work_Book.getSheet(workSheet);
		if(work_Sheet==null) work_Sheet = work_Book.createSheet(workSheet);
		
		String emails = "";
		int totalRows = work_Sheet.getPhysicalNumberOfRows();
		for(int index = 0; index < totalRows ; index++) {
			row = work_Sheet.getRow(index);
			if(flag) emails = emails + ",'" + StringUtils.substringBefore(row.getCell(0).toString().toLowerCase(), "@")+"_"+prop.getProperty("sl_groupId")+"@yopmail.com"+"'";
			else emails = emails + ",'" + row.getCell(0).toString().toLowerCase()+"'";
		}
		emails = emails.substring(1, emails.length());
		
		work_Book.close();
		file_Input_Stream.close();
		return emails;
	}*/
	
	/*public boolean deleteAllSheets(String location) throws IOException {
		file_Input_Stream = new FileInputStream(location);
		work_Book = new HSSFWorkbook(file_Input_Stream);
		int noOfSheets = work_Book.getNumberOfSheets();
		
		for(int index = noOfSheets-1 ; index >= 0 ; index--) {
			work_Book.removeSheetAt(index);
		}
		
		file = new File(location);
		file_Output_Stream = new FileOutputStream(file);
		work_Book.write(file_Output_Stream);
		work_Book.close();
		file_Output_Stream.close();
		return true;
	}*/
	
	public List<Map<String,Object>> readData(String location, String workSheet) throws IOException {
		excelEvents(workSheet, location, "openFile");
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> map = null;
		String keyValue = null, cellValue = null;
		int col = 0;
		
		ArrayList<String> key = new ArrayList<String>();
		row = work_Sheet.getRow(0);
		col = row.getLastCellNum();
		for(int index = 0; index < col ; index++) {
			key.add(row.getCell(index).toString());
		}
		
		for(int rowIndex = 1; rowIndex < work_Sheet.getPhysicalNumberOfRows() ; rowIndex++) {
			map = new HashMap<String, Object>();
			keyValue = "";
			row = work_Sheet.getRow(rowIndex);
			for(int colIndex = 0 ; colIndex < col ; colIndex++) {
				try {
					cellValue = row.getCell(colIndex).toString();
				} catch(Exception e) {
					cellValue = "null";
				}
				map.put(key.get(colIndex), cellValue);
			}
			keyValue = keyValue.substring(1, keyValue.length());
			data.add(map);
		}
		excelEvents(workSheet, location, "closeRead");
		return data;
	}
}

