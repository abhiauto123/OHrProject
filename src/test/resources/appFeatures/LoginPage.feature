Feature: Login Feature

Scenario: Login Page Title
Given User is at the login page
When User verifies the page title
Then page title should be "OrangeHRM"

Scenario: Validation message for empty Username field
Given User is at the login page
When User leaves login field blank
And User enters correct Password
And User clicks on the login Button
Then Validation messgae should be displayed

Scenario: Validation message for empty Password field
Given User is at the login page
When User leaves login field blank
And User enters correct Password
And User clicks on the login Button
Then Validation messgae should be displayed 


Scenario: Login Button present
Given User is at the login page
Then Login Button should be displayed

Scenario: Login with correct credentials
Given User is at the login page
When User enters correct Username and Password
And User clicks on the login Button
Then User should be able to login

Scenario: Login with incorrect credential
Given User is at the login page
When User enters incorrect Username or Password
And User clicks on the login Button
Then User should be navigated to Retry Login Page
And Incorrect Credentials Pop should be displayed

Scenario: Login with correct credentials on Retry Login Page
Given User is at the login page
When User enters incorrect Username or Password
And User clicks on the login Button
Then User is on the Retry Login Page
When User enters correct Username and Password
And User clicks on the login Button
Then User should be able to login

Scenario: Login with incorrect credentials on Retry Login Page
Given User is at the login page
When User enters incorrect Username or Password
And User clicks on the login Button
Then User is on the Retry Login Page
When User enters incorrect Username or Password
And User clicks on the login Button
Then Incorrect Credentials Pop should be displayed


