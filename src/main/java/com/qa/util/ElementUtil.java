package com.qa.util;



import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	public void getURL(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public WebElement findWebElement(WebDriver driver,By webelement){
		try {
			return driver.findElement(webelement);
		} catch (NoSuchElementException e) {
			
		}
	        return null;		
	}
	
	public List<WebElement> findWebElements(WebDriver driver, By webelement) {
		try {
			return driver.findElements(webelement);
		} catch (NoSuchElementException e) {
			
		}
		return null;
	}
	
	public void clickOnElement(WebElement webelement) {
		webelement.click();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();	
	}
	
	public boolean elementIsPresent(WebElement webelement) {
		try {
			return webelement.isDisplayed();
		} catch (Exception e) {
			
		}
		
	      return false;
	}
	
	public void enterTextFieldValue(WebElement textfield, String InputValue) {
		textfield.clear();
		textfield.sendKeys(InputValue);
	}
	
	public void waitForElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementInvisibility(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
		    wait.until(ExpectedConditions.invisibilityOf(element));
			
		   } catch (TimeoutException e) {
			  e.printStackTrace();
		  }
		
	}
	
	public String addRandomToString(String string) {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return string+randomNumber;
	}
	
	public void selectFromDropDown(WebDriver driver,By webelement, String elementToSelect) {
		List<WebElement> we = findWebElements(driver,webelement);
		for(int i=0;i<=we.size()-1;i++) {
			if(we.get(i).getText().equals(elementToSelect)) {
				we.get(i).click();
				break;
			}
			
		}
	}

}
