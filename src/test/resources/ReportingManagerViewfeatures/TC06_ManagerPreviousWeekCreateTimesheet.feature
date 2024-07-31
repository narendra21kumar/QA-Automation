Feature: Manager create timesheet for previous week
 
	Background:
			Given User can able to login into the manager view for previous create timesheet
  @manager
	 Scenario Outline: Manager can be able to create the timesheet for previous week
     When Click on create timesheet icon
     And Select the previous week date
     And Enter the task description,select the category,subcategory and entering hours to previous week timesheet "<SheetName>"
     And Click on the save icon
     And Click on the submit button
     And Click on the confirm button
     Then Validate the submitted timesheet response as "<Successfully Submitted Message>"
     
       	Examples:
     |       Successfully Submitted Message | SheetName      										 |
     |   Timesheet already submitted!       |  ManagerView_CreateTimesheetData   |
