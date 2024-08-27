Feature: Manager verify the rejected timesheet 
 
	Background:
			Given  User login into the manager view for verifying the rejected timesheet
  @manager
	Scenario Outline: Manager can be able to verify the rejected timesheet status
	When Click on rejected icon rejected timesheet page
	And  Click on manager show self timesheet toggle on rejected timesheet page
	And   Click on expand arrow 
	Then  Validate the rejected timesheet status
	