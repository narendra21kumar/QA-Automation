Feature: Manager Approve Timesheet For Employee Role 
 
  Background:
     Given Login as Manager Role
 @employee
  Scenario Outline: Manager Approve Timesheet For Employee Role
    When Click on TimeSheet Management Page in Manager View
    And Select the week to approve the Timesheet
   And Approved the timesheet for employee for the selected week
   Then Click on Approved Timesheet Icon in Manager View and Verify the status, Approved date "<EmployeeId>" , "<ApprovedText>"
   Examples: 
      | EmployeeId     |ApprovedText|
      | 1088           |Approved    |