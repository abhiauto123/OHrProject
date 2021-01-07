package com.stepDefinition;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.RetryLoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private static String loginPageTitle;
	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private ConfigReader configreader = new ConfigReader();
	private DashboardPage dashboard;
	private RetryLoginPage retrylogin;

	@Given("User is at the login page")
	public void user_is_at_the_login_page() {
		loginPage.getApplicationURL(configreader.init_prop().getProperty("url"));
	}

	@When("User verifies the page title")
	public void user_verifies_the_page_title() {
		loginPageTitle = loginPage.getPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be_as_expected(String expectedPageTitle) {
		Assert.assertTrue(expectedPageTitle.equals(loginPageTitle));
	}

	@When("User leaves login field blank")
	public void user_leaves_login_field_blank() {
		loginPage.enterUserName("");
	}

	@When("User enters correct Password")
	public void user_enters_correct_password() {
		loginPage.enterPassword(configreader.init_prop().getProperty("password"));
	}

	@Then("Validation messgae should be displayed")
	public void validation_messgae_should_be_displayed() {
		Assert.assertTrue(loginPage.errorMsgDisplayed());
	}

	@Then("Login Button should be displayed")
	public void login_button_should_be_displayed() {
		Assert.assertTrue(loginPage.loginButtonPresent());
	}

	@When("User enters correct Username and Password")
	public void user_enters_correct_username_and_password() {
		loginPage.enterUserName(configreader.init_prop().getProperty("username"));
		loginPage.enterPassword(configreader.init_prop().getProperty("password"));
	}

	@When("User clicks on the login Button")
	public void user_clicks_on_the_login_button() {
		Object obj = loginPage.clickLoginButton();
		if(obj.getClass().getName().contains("DashboardPage")) {
			   dashboard = (DashboardPage) obj;
		}
		else {
			   retrylogin = (RetryLoginPage) obj;
		}
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
		Assert.assertTrue(dashboard.dashboardExists());
	}

	@When("User enters incorrect Username or Password")
	public void user_enters_incorrect_username_or_password() throws InterruptedException {
		loginPage.enterUserName(configreader.init_prop().getProperty("username"));
		loginPage.enterPassword(configreader.init_prop().getProperty("_password"));
	}

	@Then("User should be navigated to Retry Login Page")
	public void user_should_be_navigated_to_retry_login_page() {
        String url = loginPage.getCurrentURL();
        Assert.assertTrue(url.contains("retryLogin"));
	}

	@Then("Incorrect Credentials Pop should be displayed")
	public void incorrect_credentials_pop_should_be_displayed(){
		Assert.assertTrue(retrylogin.errorMsgDisplayed());
	}

	@Given("User is on the Retry Login Page")
	public void user_is_on_the_retry_login_page() {
		Assert.assertTrue(retrylogin.errorMsgDisplayed());
	}


}
