package com.lntsufin.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyerHomePage {
	WebDriver driver;
	@FindBy (xpath="//span[@class='nav-link dropdown-toggle']") private WebElement productDropDown;
	@FindBy (xpath="//ul[@class='dropdown-menu multi-level show']/li[.=' Product']") private WebElement selectProductDD;
	@FindBy (xpath="//ul[@class='dropdown-menu multi-level show']/li[.=' Seller']") private WebElement selectSellerDD;
	@FindBy (xpath="//input[@placeholder='Enter product name here...']") private WebElement SearchTextFeild;
	@FindBy (xpath="//input[@placeholder='Enter seller name here...']") private WebElement SearchSellerTextFeild;
	@FindBy (xpath="//div[@class='autocomplete-container active']/div[@class='suggestions-container is-visible']/descendant::a[contains(.,'Anchor Bolts')]") private WebElement selectingProFromSuggestion;
	@FindBy (xpath="//span[.='Login/Register ']") private WebElement regLogBut;
	@FindBy (xpath="//button[.=' Login ']") private WebElement loginButon;
	
	String dynamicWE="//div[@class='autocomplete-container active']/div[@class='suggestions-container is-visible']/descendant::a[contains(.,'%s')]";
	
	String categoryWE="//span[.='%s']";
	String subCatWE="//a[.='%s']";
	private WebElement getWebElement(String dynamicWE,String replace) {
		String webElexpath=String.format(dynamicWE, replace);
		return driver.findElement(By.xpath(webElexpath));
	}
	public BuyerHomePage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickProductDD() {
		productDropDown.click();
	}
	public void selectProductDD() {
		selectProductDD.click();
	}
	public void selectSellerDD() {
		selectSellerDD.click();
	}
	public void searchSelectAutosugg(String search) {
		SearchTextFeild.sendKeys(search);
		getWebElement(dynamicWE, search).click();
	}
	public void searchSellerSelectAutosugg(String search) {
		SearchSellerTextFeild.sendKeys(search);
		getWebElement(dynamicWE, search).click();
	}
	public void selectCategory(String category,String subcat) {
		getWebElement(categoryWE, category).click();
		getWebElement(subCatWE, subcat).click();
	}
	public void clickRegLog() {
		regLogBut.click();
	}
	public void clickLoginBut() {
		loginButon.click();
	}
	

}
