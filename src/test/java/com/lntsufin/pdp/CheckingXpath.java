package com.lntsufin.pdp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingXpath {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.lntsufin.com/buyer/#/search/product-listing?distinctItemTitle=O%20Rings&categoryTitle=Pipes,%20Plumbing%20%26%20Fittings&subCategoryTitle=Pipe%20Fittings%20%26%20Plumbing&vendorOrgName=Select%20Enterprises&di=20714&searchType=Category%20Searches&useAlias=false&searchText=O%20Rings");
		System.out.println(driver.findElement(By.xpath("//h1[@class='ProductHeader text-ellipsis-line mb-0 d-inline-block w-65']")).getText());
	}

}
