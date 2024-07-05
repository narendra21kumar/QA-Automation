Feature: Login in to Official Timesheet for Admin View

@admin
Scenario Outline: Acess timesheet application with unsafe url
  Given User on the login page for Admin View
  And user should Click on "Advanced" options for Admin View
  And User should Select the option to proceed to the unsafe URLs for Admin View
  Then user Redirected to the login page and verify titles "Automation" for Admin View
  Then Verify User Name and Access of Timesheet for AdminView
  And the page title should start with "<titleOfPage>" for AdminView

    Examples: 
      | titleOfPage |
      | Automation  |