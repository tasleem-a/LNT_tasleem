package com.lntsufin.pdp;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import com.lntsuffin.genericRepository.BaseClass;
import com.lntsuffin.genericRepository.ExcelSheetData;

public class TestCase3 extends BaseClass{
	
	@Test
	public void test1() {
		String buyerURL = excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 1);
		String product = excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString()	, 0, 0);
		String seller=excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString(), 0, 1);
		String Userid=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString(), 0, 3);
		String UserPwd=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 2);
		String category = excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString()	, 0, 5);
		String subCat = excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString()	, 1, 5);
		
		buyerPage.selectCategory(category, subCat);
		ArrayList list=plpPage.getProductNames();
		Iterator it=list.iterator();
		int count=0;
		while(it.hasNext()) {
			Object Pname = it.next();
			if(it.next().toString().contains(subCat)) {
				count++;
			}
		}
		System.out.println("contains "+count+ " in this page");
		
	}


}
