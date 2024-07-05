Feature: Employee Should be Able to Create Timesheet

  @employee
  Scenario: Employee should be able to Create Timesheet
    Given User login timesheet page
    When Click on Create TimeSheet Master page
    Then Select the current week date
    And select and Enter the task disc,hours and category for Employee
    Then I validate the outcomes


