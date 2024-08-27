Feature: Manager create timesheet for current week
 
	Background:
			Given User can able to login into the manager view for create timesheet
  @manager
	 Scenario Outline: Manager can be able to create the timesheet for current week
     When  Click on create timesheet icon in manager view
     And   Select the current week from calendar icon
     Then  Verify the manager name "<managername>" and approver name "<approvername>" in create timesheet page
     And   Enter the task description,select the category,subcategory and entering hours to current week timesheet "<SheetName>"
     And   Click on save icon
     And   Click on submit button
     And   Click on confirm button
     Then  Validate the timesheet response as "<Successfully Submitted Message>"
     
       	Examples:
     |       Successfully Submitted Message | SheetName      										 |					managername				|									approvername									  |
     |   Timesheet already submitted!       |  ManagerView_CreateTimesheetData   |		Manager Name : 0		 		|								Approver Name : 0									|