Feature: Login to Timesheet as Hr

@admin
Scenario Outline: Navigate to Timesheet URL and Login as Hr
  Given Login to Timesheet with Hr Credentials
  When  Click on "Advanced" options for Hr View
  And   Select the option to proceed to the unsafe URLs for Hr View
  Then  Hr Logged in Successfully