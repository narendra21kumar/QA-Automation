Feature: Verify the status of  Approved timesheet of managers
 
	Background:
			Given user login for Approved for Managerview for manager view
	@manager
		Scenario: Verify the status of  Approved timesheet of managers
		Given Click on approved icon and enable self icon for manager view
		Then verify Approved Timesheet page for manager view