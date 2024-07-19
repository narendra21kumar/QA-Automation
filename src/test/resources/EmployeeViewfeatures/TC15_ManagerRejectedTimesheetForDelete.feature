Feature: Manager Reject Timesheet For Employee Role 
 
   Background:
     Given Login as Manager Role
	@employee
  Scenario Outline:  Manager Reject Timesheet For Employee Role 
     And Reject the timesheet "<EmployeeId>" for employeeDeletion for the selected week "<Remarks>"
   Examples: 
      | EmployeeId     |ApprovedText    |Remarks     |
      | 1088           |Approved        |Test        |
    

