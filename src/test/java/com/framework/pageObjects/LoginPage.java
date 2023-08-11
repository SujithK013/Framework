package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.testCases.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement txtUsrname;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPaswrd;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;

	public void setUsrName(String uname) {
		txtUsrname.sendKeys(uname);
	}

	public void setPassword(String passwrd) {
		txtPaswrd.sendKeys(passwrd);
	}

	public void clickSubmit() {
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
