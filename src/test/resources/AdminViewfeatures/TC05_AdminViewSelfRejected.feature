Feature: Admin able to reject the self created timesheet
 
	Background:
			Given User should be able to login Admin View of Timesheet and reject the self created timesheet
 

Scenario Outline: verify the self rejected timesheet record for admin view
Given User click on TimesheetManagementPage icon
When Enabel the showself toggle timesheet
When Click on check box based on the weekStart Month "<WeekStartDate>"
When User click on Reject button and add the "<Remarks>"
 
Examples:
     |	Remarks |empid   |WeekStartDate   | 
     |	 Test   |188     | 	1 July 2024   |