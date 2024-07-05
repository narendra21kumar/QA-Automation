Feature: Admin able to Create Timesheet

@bulk
  Scenario Outline: Admin should be able to Create Timesheet
    Given User login to Admin View
    And click on Create Timesheet  icon for Admin View of Timesheet
    When Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for Create Timesheet is
    Then Fill all mandatory fields
    And Click on save and Confirm
	Given User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page
	And Click on Reports Icon in Home page 
  And Select the values in Timesheet Submission Report Dropdown "<nameOfValue>"
  And Select the Client from client dropdow in Timesheet Submission Report "<nameOfClient>"
  And Select the Team from Team dropdow in Timesheet Submission Report "<nameOfTeam>"
  And Select the Status from Status dropdown in Timesheet Submission Report of Admin View "<nameOfStatus>"
  When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for reports page of Admin View
  When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for reports page of Admin View
  
  Examples:
  | nameOfValue             |nameOfClient|nameOfTeam  |nameOfStatus | Startmonth | Startdate | EndMonth  | EndDate |
  |Timesheet Daywise Report | CP         | CP-QA      | Approved    | May 2024   |       19  |June 2024  |      25 |
  
  