Feature: Manage Employee Page in Admin View
  @admin
  Scenario Outline: Admin Manage Employee Page 
    Given Login as Admin for Manage Emp Page
    When  Click on Manage Employee Page icon in Admin View
    Then  Validate title of the page for Manage Employee