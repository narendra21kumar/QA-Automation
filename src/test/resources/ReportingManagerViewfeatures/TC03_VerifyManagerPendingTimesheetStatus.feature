Feature: Manager verify the pending timesheet 
 
Background:
   Given User login into the manager view for verifying the pending timesheet
   
	@manager
	Scenario Outline: Manager can be able to verify the pending timesheet
  When  Click on pending approval icon
  Then  Verify the pending timesheet status "<status>"
  
  Examples:
  |status |
  |Pending|
  
