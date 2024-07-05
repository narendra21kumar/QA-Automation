Feature: Navigate to Rejected Timesheet Page for Admin View

  Background: 
    Given User should login to Admin View of Timesheet and Navigate to Rejecetd Timesheet Page

  @admin
  Scenario Outline: Verify the Rejected timeSheet record for Admin View
    Given Click on TimesheetManagementPage icon for Admin View for Rejected Page
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for Rejection
    When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" for Rejection
    And Enter Emp Id "<empid>" for Reject and enter remarks as "<remarks>" Rejected Timesheet Page
    When click on Rejected TimesheetIcon In AdminView
    Then In Admin Reject Page Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is
    And In Admin Reject Page Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is
    And Verify the Rejected Status based on Employee code

    Examples: 
      | Startmonth  | Startdate | EndMonth  | EndDate| empid  |   remarks        |
      | July 2024   |      1    | July  2024|  6    | 1083   |  QA TetsRejected |
