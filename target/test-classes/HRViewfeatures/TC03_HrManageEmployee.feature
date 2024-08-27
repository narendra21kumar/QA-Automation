Feature: Manage Employee Page in Hr View
  @admin
  Scenario Outline: Hr Manage Employee Page 
    Given Login as Hr for Manage Emp Page
    When  Click on Manage Employee Page icon in Hr View
    Then  Validate title of the page for Manage Employee in Hr view