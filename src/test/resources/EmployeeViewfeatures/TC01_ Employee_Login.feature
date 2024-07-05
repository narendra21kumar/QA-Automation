Feature: Login to Website with Unsafe URL and Launch Page Using Microsoft Account

  @employee
  Scenario Outline: Access website with Unsafe URL and login with valid credentials
    Given I am on the login page of the website for employee view
    And Click on "Advanced" option for employee view
    And Select the option to proceed to the unsafe URL for employee view
    Then Redirected to the login page and verify employee for employee view
    Then Verify User Name and Access of Timesheet
    And the page title should start with "<titleOfPage>"

    Examples: 
      | titleOfPage |
      | Automation  |
