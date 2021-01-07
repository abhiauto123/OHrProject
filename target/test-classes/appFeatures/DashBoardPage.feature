Feature:  Dashboard Page

Background: User is logged in
Given User is at the login page
When User enters correct Username and Password
And User clicks on the login Button
Then User should be able to login


Scenario: Dashborad is displayed
Given User is on the Dashboard Page
When User verifies the page title
Then page title should be "OrangeHRM"

Scenario: Admin Panel
Given User is on the Dashboard Page
When User clicks on the Admin panel
Then User Mangement Panel is displayed

Scenario: Logout
Given User is on the Dashboard Page
When User clicks on the Admin Account
And User clicks on Logout
Then User should be logged out




     
 


