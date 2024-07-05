Feature: Verify the Manager Rejected Timesheet for Employee
 
   Background:
     Given Login as Manager credentials for reject functionality
	@employee
  Scenario: reject Employee Timesheet in Reporting Manger View
  
    When Click on TimeSheet Management Page in Manager Views
    And Select the week to reject the timesheet for employee
    Then click on reject TimesheetIcon in Manager View and Verify the status and remarks
