Feature: Login to Timesheet as Admin

@code
Scenario Outline: Navigate to Timesheet URL and Login as Admin
  Given Login to Timesheet with Valid Credentials
  When  Click on "Advanced" options for Admin View
  And   Select the option to proceed to the unsafe URLs for Admin View
  Then  Admin Logged in Successfully