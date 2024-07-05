Feature: Navigate to Approved Timesheet Page for Admin View

  Background: 
    Given User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page

  @admin
  Scenario Outline: Verify the Approved timeSheet record for Admin View
    Given Click on TimesheetManagementPage icon for Admin View
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is
    And user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is
    And Enter Emp Id "<empid>" for Approval of Approved Timesheet Page
    When click on Approved TimesheetIcon In AdminView
    Then In Admin Approve Page Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is
    And In Admin Approve Page Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is
    And Verify the Approved Status based on Employee code


    Examples: 
      | Startmonth  | Startdate | EndMonth  | EndDate  | empid  |
      | July 2024   |       1   |July 2024  |     6    |   1083 |
