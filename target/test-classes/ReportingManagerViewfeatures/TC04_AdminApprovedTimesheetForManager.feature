Feature: Navigate to Approved Timesheet Page for Admin View
 
  Background:
    Given User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page for manager view
 
  @manager
  Scenario Outline: Verify the Approved timeSheet record for manager view
    Given Click on TimesheetManagementPage icon for manager view
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for manager view
    When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for manager view
    And Enter Emp Id "<empid>" for Approval of Approved Timesheet Page for manager view
    When click on Approved TimesheetIcon In AdminView for manager view
    Then In Admin Approve Page Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for manager view
    And In Admin Approve Page Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for manager view
    And Verify the Approved Status based on Employee code for manager view
 
    Examples:
      | Startmonth | Startdate  | EndMonth  | EndDate | empid  |
      | July 2024   |        1  | July 2024 |     6   |  1083  |