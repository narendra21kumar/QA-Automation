Feature: Login as Employee Role

  @employee
  Scenario Outline: Login as Employee Role
    Given Enter url and Click on Continue to Microsoft Account
    And Enter the UserName,Password and click on SignIn button
    Then Validate the page title of Employee View as "<TitleOfThePage>"
    And Logged in Successfully as an Employee

    Examples: 
      | TitleOfThePage |
      | Automation     |
