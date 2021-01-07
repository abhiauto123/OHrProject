package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtil;

public class RetryLoginPage {

	private WebDriver driver;
	private ElementUtil elementutil = new ElementUtil();

	// 1. By Locators
	private By userName = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");
	private By errorMsg = By.xpath("//div[contains(text(),'Invalid')]");
	private By retryLoginText = By.xpath("//div[text()='Retry Login']");
	
	//2. Constructor
	public RetryLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Actions
	public void enterUserName(String username) {
		WebElement usernameInput = elementutil.findWebElement(driver, userName);
		elementutil.enterTextFieldValue(usernameInput, username);
	}

	public void enterPassword(String pwd) {
		WebElement passwordInput = elementutil.findWebElement(driver, password);
		elementutil.enterTextFieldValue(passwordInput, pwd);
	}

	public DashboardPage clickLoginButton() {
		elementutil.clickOnElement(elementutil.findWebElement(driver, loginButton));
		return new DashboardPage(driver);
	}
	
	public boolean errorMsgDisplayed() {
		WebElement errorPopUp = elementutil.findWebElement(driver, retryLoginText);
		return elementutil.elementIsPresent(errorPopUp);
	}
}
