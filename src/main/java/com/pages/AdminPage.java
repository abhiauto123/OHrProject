package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

public class AdminPage {

	private WebDriver driver;
	private ElementUtil elementUtil = new ElementUtil();
	private ConfigReader configReader = new ConfigReader();

	// 1.Locators
	private By adminPanel = By.id("menu_admin_viewAdminModule");
	private By oranizationMenu = By.id("menu_admin_Organization");
	private By locations = By.id("menu_admin_viewLocations");
	private By locationPageTitle = By.xpath("//li[text()='Locations']");
	private By preloader = By.id("preloader");
	private By addLocationIcon = By.xpath("//i[text()='add']");
	private By addLocNameInput = By.id("name");
	private By countryDropDownArrow = By.xpath("(//input[contains(@value,'Select')])[1]");
	private By countryDropDownList = By.xpath("(//input[contains(@value,'Select')]/following-sibling::ul)[1]//li");
	private By cityInputBox = By.id("city");
	private By zipCodeInputBox = By.id("zipCode");
	private By saveButton = By.xpath("//a[text()='Save']");
	private By savedSucessfully = By.xpath("//div[text()='Successfully Saved']");
	private By locationNameOnList = By.xpath("//ng-include[@src='template']//span");

	// 2. Constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Actions
	public void clickOnAdminPanel() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, adminPanel));
	}

	public void clickOnOrganization() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, oranizationMenu));
	}

	public void clickOnLocations() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, locations));
		elementUtil.waitForElementInvisibility(driver, elementUtil.findWebElement(driver, preloader));
	}

	public boolean locationPageDisplayed() {
		return elementUtil.elementIsPresent(elementUtil.findWebElement(driver, locationPageTitle));
	}

	public void clickOnAddLocation() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, addLocationIcon));
		elementUtil.waitForElement(driver, elementUtil.findWebElement(driver, addLocNameInput));
	}

	public boolean addLocNameInputDisplayed() {
		return elementUtil.elementIsPresent(driver.findElement(addLocNameInput));
	}

	public void clickOnSelectCountry() {
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, countryDropDownArrow));
	}

	public void addLocationData(String locName, String country, String city, String zipCode) {
		// Filling location Name
		elementUtil.enterTextFieldValue(elementUtil.findWebElement(driver, addLocNameInput),elementUtil.addRandomToString(locName));
		// clicking on select country Drop Down
		clickOnSelectCountry();
		// Selecting Country
		elementUtil.selectFromDropDown(driver, countryDropDownList, country);
		// Entering City Name
		elementUtil.enterTextFieldValue(elementUtil.findWebElement(driver, cityInputBox), city);
		// Entering Zip code
		elementUtil.enterTextFieldValue(elementUtil.findWebElement(driver, zipCodeInputBox), zipCode);
	}

	public void clickOnLocationSaveBtn() {
		// Clicking on Save Button
		elementUtil.clickOnElement(elementUtil.findWebElement(driver, saveButton));
		// Waiting for loader to dissapear
		elementUtil.waitForElementInvisibility(driver, elementUtil.findWebElement(driver, preloader));
	}

	public boolean locationSavedMsgDisplayed() {
		return elementUtil.elementIsPresent(elementUtil.findWebElement(driver, savedSucessfully));
	}

	public boolean locationExists() {
		return elementUtil.elementIsPresent(elementUtil.findWebElement(driver, locationNameOnList));
	}

}
