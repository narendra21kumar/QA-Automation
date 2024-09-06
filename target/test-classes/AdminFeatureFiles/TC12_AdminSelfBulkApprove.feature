Feature: Approve Admin self Timesheet Record in Bulk
  @code
  Scenario: Admin should be able to Approve self Timesheet records in bulk
    Given Login as Admin for self approval of Timesheet
    When  Click on Admin Timesheet Management Page Icon
    And   Click on Enable Toggle icon
    And   Click on checkbox for self Bulk Approval
    And   Click on Approved Timesheet Icon In AdminView for self approval of Timesheet
    And   Click on Enable Toggle icon
    #Then  Verify the Approved Status based on Employee code for self timesheet "<Date>"

    #Examples: 
    #|  empId|
    #|   188 |