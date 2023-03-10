package com.lntsuffin.genericRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lntsufin.objectRepository.BuyerHomePage;
import com.lntsufin.objectRepository.LoginPage;
import com.lntsufin.objectRepository.PdpPage;
import com.lntsufin.objectRepository.PlpPage;


public class BaseClass {
	protected PropertyFileLibrary propertyFileLibrary;
	protected JavaLibrary javaLibrary;
	protected ExcelLibrary excelLibrary;
	protected WebDriverLibrary webDriverLibrary;
	protected WebDriver driver;
	protected BuyerHomePage buyerPage;
	protected PlpPage plpPage;
	protected PdpPage pdpPage;
	protected LoginPage loginPage;
	public static WebDriver sdriver;
@BeforeClass
public void tes1()
{
	
	javaLibrary=new JavaLibrary();
	excelLibrary=new ExcelLibrary();
	webDriverLibrary=new WebDriverLibrary();
	propertyFileLibrary=new PropertyFileLibrary();
	
			
			excelLibrary.openExcel(ConstantPaths.EXCELFILE_PATH);
			propertyFileLibrary.openPropertyFile(ConstantPaths.PROPERTY_FILE_PATH.toString());
			String browser=propertyFileLibrary.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
			String buyerURL=excelLibrary.getDataFromExcel(ExcelSheetData.USERCRE.convertToString(), 0, 1); 
			long timeout=(Long) javaLibrary.stringToAnyDatatype(propertyFileLibrary.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()),"long");
			//open excel
			
			
			//Browser Launch
			ThreadSafe.setWebDriverLibrary(webDriverLibrary);
			driver=webDriverLibrary.launchApplication(browser, buyerURL,timeout);
			sdriver=driver;
			
	buyerPage=new BuyerHomePage(driver);
		plpPage=new PlpPage(driver);
		pdpPage=new PdpPage(driver);
		loginPage=new LoginPage(driver);
			
}
@BeforeMethod
public void CommonAction()
{
	//login
			
			 
//			String Admin_un=propertyFileLibrary.getDataFromPropertyFile(PropertyFileKeys.AD_USERNAME.convertToString());
//			String Admin_pswd=propertyFileLibrary.getDataFromPropertyFile( PropertyFileKeys.AD_PASSWORD.convertToString());
//			loginPage.loginAction(Admin_un, Admin_pswd);
//			webDriverLibrary.acceptAlert();
			
}
@AfterMethod
public void LogoutAction()
{
//	commonpage.Logout(webDriverLibrary, driver);
//	
}
@AfterClass
public void closeAll()
{
	webDriverLibrary.closeBrowser(excelLibrary, propertyFileLibrary);
}
}
