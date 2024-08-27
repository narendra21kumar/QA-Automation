Feature: Login to Website with Unsafe URL and Launch Page Using Microsoft Account

@manager1
  Scenario Outline: User should be able to login to the manager view with valid credentials on timesheet application
  	Given User on the login page and click on continue with microsoft
    When  User click on advanced button
    And   User click on proceed link
    And   User enter the username in the username Field and click on next button
    And   User enter the password in the password Field and click on sign in button
    And   User click on yes button
    Then  Validate the title "<title of the page>" of the timesheet management page 
    
    Examples:
    |			title of the page	  |
    |  Timesheet Management   |