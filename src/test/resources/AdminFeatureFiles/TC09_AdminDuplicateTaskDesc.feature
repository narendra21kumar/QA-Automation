Feature: Admin View Duplicate Task Description

 @code
  Scenario: Duplicate Task Description in Admin
    Given Login as Admin for Duplicate Task Desc functionality
    When  Click on Create Timesheet Icon for DuplicateTask Desc in Admin
    And   Select the date from calendor for DuplicateTask Desc in Admin
    And   Enter Duplicate Task Desc and Category and Subcategory in Admin
    Then  Validate error triggered as Duplicate Task Desc in Admin