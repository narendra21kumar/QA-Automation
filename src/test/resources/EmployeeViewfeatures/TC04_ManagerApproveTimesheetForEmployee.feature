Feature: Manager Approve Timesheet For Employee View 
 
  Background:
     Given Login as Manager credentials
 @employee
  Scenario: Approved Employee Timesheet in Reporting Manger View
    When Click on TimeSheet Management Page in Manager View
    And Select the week to approve
    And Approved the timesheet for employee for selected week
    Then click on Approved TimesheetIcon in Manager View and Verify the status and Approved date