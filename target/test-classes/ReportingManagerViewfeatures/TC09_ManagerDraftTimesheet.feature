Feature: Manager Draft Timesheet Functionality and Verify

  Background: 
    Given Manager login into the timesheet for Draft Timesheet

  @manager
  Scenario Outline: Verify draft functionality
  When Click on view Timesheet 
  And  Select the past week from calendar icon
  Then Verify the edit icon draft timesheet and page title as view timesheet "<TimesheetHeader>"

	 Examples:
  | TimesheetHeader    |
  |  View Timesheet    |