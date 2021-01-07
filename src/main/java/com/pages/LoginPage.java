package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementutil = new ElementUtil();

	// 1. By Locators
	private By userName = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");
	private By errorMsg = By.id("spanMessage");

	// 2. Constructor of the Page Class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions

	public void getApplicationURL(String url) {
		elementutil.getURL(driver, url);
	}
	
	
	public String getCurrentURL() {
		return elementutil.getCurrentURL(driver);
	}

	public String getPageTitle() {
		return elementutil.getPageTitle(driver);
	}

	public boolean loginButtonPresent() {
		return elementutil.elementIsPresent(elementutil.findWebElement(driver, loginButton));
	}

	public void enterUserName(String username) {
		WebElement usernameInput = elementutil.findWebElement(driver, userName);
		elementutil.enterTextFieldValue(usernameInput, username);
	}

	public void enterPassword(String pwd) {
		WebElement passwordInput = elementutil.findWebElement(driver, password);
		elementutil.enterTextFieldValue(passwordInput, pwd);
	}

	public Object clickLoginButton() {
		elementutil.clickOnElement(elementutil.findWebElement(driver, loginButton));
		DashboardPage dashboardPage = new DashboardPage(driver);
		if(dashboardPage.dashboardExists()) {
			return dashboardPage;
		}
		else
			return new RetryLoginPage(driver);
	}

	public boolean errorMsgDisplayed() {
		return elementutil.elementIsPresent(elementutil.findWebElement(driver, errorMsg));
	}

	public DashboardPage doLogin(String username, String password) {
		// enterUserName(username);
		enterPassword(password);
		clickLoginButton();
		return new DashboardPage(driver);
	}

}
