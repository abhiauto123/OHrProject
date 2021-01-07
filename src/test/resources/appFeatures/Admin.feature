Feature: Admin feature

Background: User is logged in
Given User is at the login page
When User enters correct Username and Password
And User clicks on the login Button
Then User should be able to login

Scenario: Add Location
Given User is on the Dashboard Page
When User clicks on Admin panel
And User clicks on Oraganization section
And User click on Locations link
Then Locations page should be dispalyed
And User clicks on Add Location Icon
Then Add location form should be displayed
And User enters the location details
|location|India|City|99988|
And click on Save button
Then Sucessfully saved message should be displayed
And Location added should be in the Locations list
