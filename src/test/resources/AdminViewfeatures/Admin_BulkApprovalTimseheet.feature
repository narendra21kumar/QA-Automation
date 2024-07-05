Feature: Verify the Bulk Approved Timesheet in Manager
 
  Background:
    Given User login for bulkapproved timesheet page for admin view bulk approval
 
@bulk
  Scenario Outline: Verify the Bulk Approved Timesheet for admin view bulk approval
    Given Click on TimeSheet Management page for admin view bulk approval
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for bulk admin approval
    When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for bulk admin approval
    And search by "<name>" for bulk admin approval
   	And Click on checkbox for bulk approval for admin view bulk approval
   	
   	
    Examples:
      | Startmonth | Startdate | EndMonth | EndDate | name          |
      | May 2024   |       12  |May 2024  |      25 |Jampana Ramya  |