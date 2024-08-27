Feature: Manage Delete Employee Page in Hr View
  @admin
  Scenario Outline: Hr View Manage Delete Employee Page
    Given Login as Hr for Manage Delete Employee
    When  Click on  Manage Delete Employee icon in Hr View
    Then  Validate title of the page for  Manage Delete Employee in Hr view