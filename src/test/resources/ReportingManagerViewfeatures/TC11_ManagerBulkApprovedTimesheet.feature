Feature: Bulk approved timesheets in timesheet management page for manager view
 
  Background:
    Given User login into the manager view for bulkapproved timesheets in timesheet management page 
 
  @manager
  Scenario Outline: Bulk approved timesheets in manager view
    When Click on timeSheet management page 
    And Select the previous date in timesheet management page from calender icon
   	And Check the header part checkbox
   	And Click on approve button
   	Then Validate the bulk approved timesheet response as "<timesheet approved sucessfully>" and "<no records to display>"
   	
   	Examples:
   	|timesheet approved sucessfully   |       no records to display							|
   	|Timesheet approved successfully! |				No records to display							|