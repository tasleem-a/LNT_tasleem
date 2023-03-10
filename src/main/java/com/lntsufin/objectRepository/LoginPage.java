package com.lntsufin.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="signInName") private WebElement emailIdTextField;
	@FindBy(xpath="//button[.='Continue']") private WebElement continueButton;
	@FindBy(id="password") private WebElement pwdTextField;
	@FindBy(xpath="//button[.='Sign in']") private WebElement signInButton;
	public LoginPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String emailId,String pwd) {
		emailIdTextField.sendKeys(emailId);
		continueButton.click();
		pwdTextField.sendKeys(pwd);
		signInButton.click();
	}
	

}
