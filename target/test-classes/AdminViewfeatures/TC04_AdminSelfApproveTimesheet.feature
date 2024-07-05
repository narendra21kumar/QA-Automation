Feature: Navigate to Approved Timesheet Page for Admin View

  Background: 
    Given User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page for self timesheet

  @admin
  Scenario Outline: Verify the Approved timeSheet record for Admin View for self timesheet
    Given Click on TimesheetManagementPage icon for Admin View for self Timesheet
    When Click on Enable Toggle icon
    And Enter Emp Id "<empid>" for Approval of Approved Timesheet Page of self
    When click on Approved TimesheetIcon In AdminView for self timesheet
    When Click on Enable Toggle icon
    #Then In Admin Approve Page Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for self timesheet
    #And In Admin Approve Page Enter End Month "<EndMonth>" and Enter End date "<EndDate>" for self timesheet
    And Verify the Approved Status based on Employee code for self timesheet "<Date>"

    Examples: 
    |  empid|Date        |
    |   188 |1 July 2024 |

    
 