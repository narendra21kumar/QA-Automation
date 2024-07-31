Feature: Manager verify the approved timesheet 
 
	Background:
			Given  User login into the manager view for verifying the approved timesheet
  @manager
	Scenario Outline: Manager can be able to verify the approved timesheet status 
	When Click on approved icon
	And Click on show self timesheet toggle
	And Click on arrow for expanding the approved timesheet
	Then Verify the approved timesheet record status
	

