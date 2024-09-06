Feature: Navigate to Admin View for Self Approve Timesheet Record
 @code
  Scenario Outline: Admin should self approve Admin Timesheet
    Given Login as Admin for self approval of Timesheet
    And   Click on Admin Timesheet Management Page Icon
    And   Click on Enable Toggle icon
    And   Approve the timesheet for Admin for current week record "<empId>"
    And   Click on Approved Timesheet Icon In AdminView for self approval of Timesheet
    And   Click on Enable Toggle icon
    #Then Verify the Approved Status based on Employee code for self timesheet "<Date>"

    Examples: 
    |  empId  |
    |  123450 |

    
 