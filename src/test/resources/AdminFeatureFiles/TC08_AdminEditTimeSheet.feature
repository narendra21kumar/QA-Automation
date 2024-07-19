Feature: Edit Employee Rejected Timesheet record
  @admin
  Scenario: Edit Employee Rejected Timesheet for Previous Week
    Given  login as Admin Timesheet for edit functioanlity
    When   Click on Create TimeSheet icon and select the previous week in calendor for admin edit
    And    Click on Edit Icon in Edit Page
   	And    Update Timesheet and Submit
   	
   	