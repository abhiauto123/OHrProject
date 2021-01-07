package com.stepDefinition;

import java.util.List;

import org.junit.Assert;

import com.pages.AdminPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	
	private AdminPage adminPage = new AdminPage(DriverFactory.getDriver());
	
	@When("User clicks on Admin panel")
	public void user_clicks_on_admin_panel() {
	   adminPage.clickOnAdminPanel();
	}

	@When("User clicks on Oraganization section")
	public void user_clicks_on_oraganization_section() {
	    adminPage.clickOnOrganization();
	}

	@When("User click on Locations link")
	public void user_click_on_locations_link() {
	    adminPage.clickOnLocations(); 
	}

	@Then("Locations page should be dispalyed")
	public void locations_page_should_be_dispalyed() {
	   Assert.assertTrue(adminPage.locationPageDisplayed());
	}

	@Then("User clicks on Add Location Icon")
	public void user_clicks_on_add_location_icon() {
	   adminPage.clickOnAddLocation();
	}

	@Then("Add location form should be displayed")
	public void add_location_form_should_be_displayed() {
	   Assert.assertTrue(adminPage.addLocNameInputDisplayed()); 
	}

	@Then("User enters the location details")
	public void user_enters_the_location_details(DataTable datatable) {
		List<String> data = datatable.asList();
		adminPage.addLocationData(data.get(0), data.get(1), data.get(2), data.get(3));

	}

	@Then("click on Save button")
	public void click_on_save_button() {
	   adminPage.clickOnLocationSaveBtn();
	}

	@Then("Sucessfully saved message should be displayed")
	public void sucessfully_saved_message_should_be_displayed() {
	   Assert.assertTrue(adminPage.locationSavedMsgDisplayed());
	}

	@Then("Location added should be in the Locations list")
	public void location_added_should_be_in_the_locations_list() {
	   Assert.assertTrue(adminPage.locationExists());
	}


}
