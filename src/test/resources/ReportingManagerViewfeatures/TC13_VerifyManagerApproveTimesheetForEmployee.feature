Feature: Verify manager approve timesheet for employee view
 
  Background:
     Given Manager login into the timesheet for verifying the approved timesheet for employee
@manager
  Scenario Outline: Verify manager approve timesheet for employee view
    When Click on approved timesheet page icon in manager view
    And  Select the current week from calendar
    Then Verify the employee timesheet status "<empid>" , "<ApprovedText>"
   Examples:
      | empid     		 |ApprovedText|
      | 123451         |Approved    |