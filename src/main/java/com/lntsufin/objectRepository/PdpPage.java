package com.lntsufin.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PdpPage {
	WebDriver driver;
	@FindBy(xpath="//button[.='Quick RFQ']") private WebElement quickRFQButton;
	@FindBy(xpath="//h1[@class='ProductHeader text-ellipsis-line mb-0 d-inline-block w-65']") private WebElement productName;
	@FindBy(name="pincode") private WebElement PincodeTF;
	@FindBy(id="submit_check") private WebElement checkButton;
	@FindBy(xpath="//button[.='Add To Cart") private WebElement addTocartButton;
	@FindBy(xpath="//button[.='Buy Now']") private WebElement buyNowButton;
	
	
	public PdpPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickQuickRFQ() {
		quickRFQButton.click();
	}
	public String getProductname() {
		String proN=productName.getText();
		return proN;
	}

}
