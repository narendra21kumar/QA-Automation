Feature: Verify manager reject timesheet for employee view
 
  Background:
     Given Manager login into the timesheet for verifying the rejected timesheet for employee
@manager
  Scenario Outline: Verify manager rejected timesheet for employee view
    When Click on rejected timesheet page icon in manager view
    And  Select the previous week from calendar
    Then Verify the employee rejected timesheet status "<empid>" , "<RejectedText>"
   Examples:
      | empid     		 |RejectedText|
      | 1087           |Rejected    |