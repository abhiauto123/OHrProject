package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.qa.util.ElementUtil;



public class DashboardPage {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();

	//1. By Locators Elements
	private By dashboard = By.xpath("//li[text()='Dashboard']");
	private By adminSection = By.xpath("(//span[text()='Admin'])[2]");
	private By adminAccount = By.xpath("//i[text()='keyboard_arrow_down']");
	private By userManagement = By.xpath("//span[text()='User Management']");
	private By logoutlink = By.id("logoutLink");

	//2 . Constructor

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	//3. Actions
	public String getPageTitle() {
		return elementUtil.getPageTitle(driver);
	}

	public boolean dashboardExists() {
		return elementUtil.elementIsPresent(elementUtil.findWebElement(driver, adminSection));
	}

	public void clickOnAdminSection() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, adminSection));
	}

	public boolean userManagementExists() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, adminSection));
		return elementUtil.elementIsPresent(elementUtil.findWebElement(driver, userManagement));
	}
	
	public void clickOnAdminAccount() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, adminAccount));
		elementUtil.waitForElement(driver, elementUtil.findWebElement(driver, logoutlink));
	}
	
	public void clickOnLogout() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, logoutlink));
	}
}
