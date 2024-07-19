Feature: Admin Reports Page
@admin
  Scenario Outline: Reports Page in Admin View
   Given Login as Admin for Reports
    When Click on Reports Icon
    And  Select values from Timesheet Submission Report Dropdown "<nameOfValue>"
    And  Select Client from client dropdown in Timesheet Submission Report "<nameOfClient>"
    And  Select Team from Team dropdown in Timesheet Submission Report "<nameOfTeam>"
    And  Select Status from Status dropdown in Timesheet Submission Report of Admin View "<nameOfStatus>"
    And  Click on Calendor Icon for Start Date
    And  Select Start Date
    And  Click on Calendor for selection of End Date
    And  Select End Date
    Then Validate title of the page for Admin Reports
    
     Examples: 
      | nameOfValue                | nameOfClient | nameOfTeam | nameOfStatus |VerifyempName|
      |Timesheet Submission Report | CP           |     CP     |    Pending   |Test01      | 