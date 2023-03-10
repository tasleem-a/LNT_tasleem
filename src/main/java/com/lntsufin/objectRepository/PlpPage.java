package com.lntsufin.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PlpPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[.='Filter By']/ancestor::div[@class='sidebar-nav navMenu']/div[@id='filterAccordion']/descendant::a[@class='card-link' and contains(.,'Seller')]/parent::div/following-sibling::div/descendant::input[@placeholder='Search By']") private WebElement filerBySeller;
	String dynamicWE="//a[@class='card-link' and contains(.,'Seller')]/parent::div/following-sibling::div/descendant::input[@placeholder='Search By']/ancestor::form/following-sibling::form/descendant::label[@title='Select Enterprises']";
	String dynamicSellername="//a[@title='%s']";
	String dynamicPOQ="//a[@title='%s']/ancestor::div[@class='position-relative']/descendant::div[.=' PRICE ON REQUEST ']";
	String dynamicProductName="//a[@title='%s']/ancestor::div[@class='position-relative']/descendant::h3";
	@FindBy(xpath="//h3[@class='Prodtile-title w-100 prodtitle-ellipsis']") private List<WebElement> ProductNames;
	private WebElement getWebElement(String dynamicWE,String replace) {
		String webElexpath=String.format(dynamicWE, replace);
		return driver.findElement(By.xpath(webElexpath));
	}
	public PlpPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String Applyfilter(String SellerName) {
		filerBySeller.sendKeys(SellerName);
		getWebElement(dynamicWE, SellerName).click();
		return getWebElement(dynamicSellername, SellerName).getText();
	}
	public void clickPOR(String SellerName) {
		getWebElement(dynamicPOQ, SellerName).click();
	}
	public String getProductName(String seller)
	{
	String ProductName=getWebElement(dynamicProductName, seller).getAttribute("title");
	return ProductName;	
	}
	public ArrayList getProductNames() {
		ArrayList list=new ArrayList();
		for(WebElement ele:ProductNames) {
		list.add(ele.getAttribute("title"));
		}
		return list;
	}

}
