Feature: Manager Reject Timesheet For Employee Role 
 
   Background:
     Given Login as Manager's Role
	@employee
  Scenario Outline:  Manager Reject Timesheet For Employee Role 
  
    When Click on TimeSheet Management Page in Manager's View
    And Select the week to Reject the Employee Timesheet
    And Reject the timesheet for employee for the selected week "<Remarks>"
    And Click on Reject Timesheet Icon in Manager View 
    Then Validate the status Rejected date
    
    Examples: 
      | EmployeeId     |Remarks     |
      | 1088           |Test        |
