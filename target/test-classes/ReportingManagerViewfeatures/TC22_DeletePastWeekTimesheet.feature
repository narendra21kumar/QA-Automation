Feature: Delete current week timesheet 
 
	Background:
			Given Manager login into the timesheet application
  @manager
	 Scenario Outline: Verify Admin Able To Delete Timesheet For Current Week
     When Click on create timesheet page in manager view
     And Select the past week from calender in manager view
     And Click on edit icon And add row icon in timesheet
     And Click on delete icons for delete the timeSheet
     Then Validate the deletion of timesheet response as "<Successfully Deleted Message>"
     
       	Examples:
     |   Successfully Deleted Message   |
     |  Task deleted successfully!      |