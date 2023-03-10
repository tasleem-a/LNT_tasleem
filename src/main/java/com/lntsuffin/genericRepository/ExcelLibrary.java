package com.lntsuffin.genericRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	private Workbook workbook;
	private FileInputStream fis;
	private FileOutputStream fos;
	private DataFormatter df;
	
	public void openExcel(String excelPath)
	{try {
		fis=new FileInputStream(excelPath);
		df=new DataFormatter();
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	/**
	 * this method is used to get the data from excel based on sheetname, rowno and cell no
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String sheetName,int rowNumber, int cellNumber)
	{
		System.out.println(sheetName);
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}
	/**
	 * This method is used to write the data into the excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setDataToExcel(String excelPath, String sheetName, int rowNumber, int cellNumber, String data)
	{
		try {
			fos=new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(data);
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * get the last row number in the excel and count of the rows +1
	 * @param excelPath
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) {
		
	return workbook.getSheet(sheetName).getLastRowNum();
		}
	/**
	 * used to close the workbook and excel
	 * @throws IOException
	 */
	public void closeExcel()
	{
		try {
			workbook.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * fetching single row data 
	 * @param sheetName
	 * @param colcount
	 * @return
	 */
	public String[][] getDataFromExcel(String sheetName, int colcount){
		int rowNumber=getRowCount(sheetName);
		String[][] testdata=new String[1][colcount];
		for(int j=0;j<colcount;j++){
		testdata[0][j]=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(j));
		}
		return testdata;
	}
	

}
