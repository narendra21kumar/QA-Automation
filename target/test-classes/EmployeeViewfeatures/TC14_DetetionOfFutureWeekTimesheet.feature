Feature:Verify Employee Able To Delete Timesheet For Future Week
 
	Background:
			Given Log in As a Employee Role
  @employee
	 Scenario Outline: Verify Employee Able To Delete Timesheet For Future Week
     And Click On Create Timesheet Page
     And Select the Future Week from Calender
     And Click On Edit Icon And Add A Row Icon
     And Click On Delete Icons for Delete TimeSheet For Future Week
     Then Validation of Deletion of TimeSheet Response As "<Successfully Deleted Message>"
     
       	Examples:
     |   Successfully Deleted Message   |
     |  Task deleted successfully!      |
      
