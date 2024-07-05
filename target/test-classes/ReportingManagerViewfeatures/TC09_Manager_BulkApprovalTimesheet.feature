Feature: Verify the Bulk Approved Timesheet in Manager
 
  Background:
    Given User login for bulkapproved timesheet page for manager view
 
  @manager
  Scenario:  Verify the Bulk Approved Timesheet in Manager
    Given Click on TimeSheet Management page for manager view
   	And Select the  WeekDate from the calendar for manager view
   	And Click on checkbox for bulk approval for manager view