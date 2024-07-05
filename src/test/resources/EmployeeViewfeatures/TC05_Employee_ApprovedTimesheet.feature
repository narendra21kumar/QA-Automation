Feature: Employee Approved Timesheet Status Check

  Background: 
    Given User login timesheet page with Username and Password

  @employee
  Scenario: Verify the Approved timeSheet
    Then click on Approved TimesheetIcon
    And Verify the Approved Status and approved On date
   
