Feature: Login as Employee Role to verify the Draft Functionality
  Background: 
    Given Log In as the Employee Role

  @employee
  Scenario Outline: Login as Employee Role to verify the Draft Functionality
  Given Select the Past week from calender icon
	And Verify the Draft Functionlity by page Title as view Timesheet "<TimesheetHeader>" 
	
	 Examples:
  | TimesheetHeader    |
  |  View Timesheet    |