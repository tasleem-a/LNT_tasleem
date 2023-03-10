package com.lntsuffin.genericRepository;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {
	private static ThreadLocal<WebDriverLibrary> webDriverLibrary=new ThreadLocal();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal();
	
	public static WebDriverLibrary getWebDriverLibrary() {
		return webDriverLibrary.get();
	}
	public static void setWebDriverLibrary(WebDriverLibrary swebDriverLibrary) {
webDriverLibrary.set(swebDriverLibrary);
	}
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest sextentTest) {
		extentTest.set(sextentTest);
	}

}
