package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardSteps {
	
	private static String dashBoardPageTitle;
	private WebDriver driver = DriverFactory.getDriver();
	private DashboardPage dashboardPage = new DashboardPage(driver);
	private ConfigReader configreader = new ConfigReader();
    private LoginPage loginpage; 

	@Given("User is on the Dashboard Page")
	public void user_is_on_the_dashboard_page() {
		dashBoardPageTitle = dashboardPage.getPageTitle();
		Assert.assertTrue(configreader.init_prop().getProperty("dasboardPageTitle").equals(dashBoardPageTitle));
	}

	@When("User clicks on the Admin panel")
	public void user_clicks_on_the_admin_panel() {
		dashboardPage.clickOnAdminSection();
	}
	

	@Then("User Mangement Panel is displayed")
	public void user_mangement_panel_is_displayed() {
		Assert.assertTrue(dashboardPage.userManagementExists()); 
	}

	@When("User clicks on the Admin Account")
	public void user_clicks_on_the_admin_account() {
	    dashboardPage.clickOnAdminAccount();
	}

	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
	    dashboardPage.clickOnLogout();
	    loginpage = new LoginPage(driver);
	}

	@Then("User should be logged out")
	public void user_should_be_logged_out() {
	   Assert.assertTrue(loginpage.loginButtonPresent());
	}

}
