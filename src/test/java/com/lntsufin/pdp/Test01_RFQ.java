package com.lntsufin.pdp;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lntsuffin.genericRepository.BaseClass;
import com.lntsuffin.genericRepository.ExcelSheetData;


public class Test01_RFQ extends BaseClass {
	
@Test
public void test1() {
	String buyerURL = excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 1);
	String product = excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString()	, 0, 0);
	String seller=excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString(), 0, 1);
	String Userid=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString(), 0, 3);
	String UserPwd=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 2);
	//driver.get(buyerURL);
	buyerPage.clickProductDD();
	buyerPage.selectProductDD();
	buyerPage.searchSelectAutosugg(product);
	String validateSeller = plpPage.Applyfilter(seller);
	Assert.assertEquals(validateSeller, seller);
	String expProductName=plpPage.getProductName(validateSeller);
	System.out.println(expProductName);
	plpPage.clickPOR(validateSeller);
	System.out.println(driver.getCurrentUrl());
	Set<String> windowHandles = driver.getWindowHandles();

	// Switch to the second window tab
	for (String windowHandle : windowHandles) {
	    driver.switchTo().window(windowHandle);
	    if (driver.getCurrentUrl().contains("subCategoryTitle")) {
	       
	    }
	    else {
	    	 break;
	    }
	}
	//webDriverLibrary.switchWinBasedOnUrl(driver, "subCategoryTitle");
	System.out.println(driver.getCurrentUrl());
	String actualProductName=pdpPage.getProductname();
	Assert.assertEquals(expProductName,actualProductName );
	pdpPage.clickQuickRFQ();
	loginPage.login(Userid, UserPwd);
	
	
}

}
