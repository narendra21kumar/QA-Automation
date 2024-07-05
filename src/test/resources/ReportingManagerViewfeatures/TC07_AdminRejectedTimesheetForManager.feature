Feature: Navigate to Rejected Timesheet Page for Admin View
 
  Background:
    Given User should login to Admin View of Timesheet and Navigate to Rejecetd Timesheet Page for manager view
 
  @manager
  Scenario Outline: Verify the Rejected timeSheet record for Admin View
    Given Click on TimesheetManagementPage icon for Admin View for Rejected Page for manager view
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for Rejection for manager view
    When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" for Rejection for manager view
    And Enter Emp Id "<empid>" for Reject and enter remarks as "<remarks>" Rejected Timesheet Page for manager view
    When click on Rejected TimesheetIcon In AdminView for manager view
    Then In Admin Reject Page Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for manager view
    And In Admin Reject Page Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for manager view
    And Verify the Rejected Status based on Employee code for manager view
 
    Examples: 
      | Startmonth  | Startdate | EndMonth   | EndDate  | empid |   remarks        |
      | July 2024   |     1     | July 2024  |    6     |  1083 | QA Rejected      |
 