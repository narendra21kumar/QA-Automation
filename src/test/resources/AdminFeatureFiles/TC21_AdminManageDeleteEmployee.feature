Feature: Manage Delete Employee Page in Admin View
  @admin
  Scenario Outline: Admin View Manage Delete Employee Page
    Given Login as Admin for Manage Delete Employee
    When  Click on  Manage Delete Employee icon in Admin View
    Then  Validate title of the page for  Manage Delete Employee