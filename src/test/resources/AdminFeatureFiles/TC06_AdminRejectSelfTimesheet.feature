Feature: Admin Rejects Self Timesheet Record
@admin
  Scenario Outline: Reject Admin Self Timesheet record 
    Given Login as Admin for Self Reject Timesheet
    When  Click on Timesheet Management Page icon for self Reject Timesheet
    And   Enable the Show Self Timesheet toggle button
    And   Reject Self Timesheet record for given employee id: "<empid>"
    Then  Validate the rejected record
Examples:
 
     |empid   |
     |188     |