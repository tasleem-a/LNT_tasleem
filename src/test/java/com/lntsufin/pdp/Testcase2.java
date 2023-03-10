package com.lntsufin.pdp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.lntsuffin.genericRepository.BaseClass;
import com.lntsuffin.genericRepository.ExcelSheetData;
import com.lntsufin.objectRepository.BuyerHomePage;
import com.lntsufin.objectRepository.LoginPage;
import com.lntsufin.objectRepository.PdpPage;
import com.lntsufin.objectRepository.PlpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 extends BaseClass{
	
	@Test
	public void test1() {
		String buyerURL = excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 1);
		String product = excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString()	, 0, 0);
		String seller=excelLibrary.getDataFromExcel(ExcelSheetData.PRODUCT.convertToString(), 0, 1);
		String Userid=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString(), 0, 3);
		String UserPwd=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString()	, 0, 2);
		buyerPage.clickProductDD();
		buyerPage.selectSellerDD();
		buyerPage.searchSellerSelectAutosugg(seller);
		
	}

}
