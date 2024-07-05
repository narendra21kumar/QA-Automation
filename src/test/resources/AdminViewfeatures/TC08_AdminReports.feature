Feature: Navigate to Reports Page of Admin View and validate

  Background: 
    Given User Should Log in to Timesheet Admin View for Reports page validations

  @admin
  Scenario Outline: Verify Reports Page of Timesheet Admin View and Validate as per the Requirement
    Then Click on Reports Icon in Home page
    And Select the values in Timesheet Submission Report Dropdown "<nameOfValue>"
    And Select the Client from client dropdow in Timesheet Submission Report "<nameOfClient>"
    And Select the Team from Team dropdow in Timesheet Submission Report "<nameOfTeam>"
    And Select the Status from Status dropdown in Timesheet Submission Report of Admin View "<nameOfStatus>"
    When user Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" is for reports page of Admin View
    When user Enter End Month "<EndMonth>" and Enter End date "<EndDate>" is for reports page of Admin View
    And Search for text and filter the reports records for Admin View "<text>"
    And Verify Employee Status from Reports based on "<EmpName>" and "<Status>" and "<SubDate>" of Admin View
    And Search for text and filter the reports records for Admin View "<text>"

    Examples: 
      | nameOfValue                | nameOfClient | nameOfTeam | nameOfStatus | Startmonth  | Startdate | EndMonth  | EndDate  |EmpName                | Status      |SubDate   |text       |
      |Timesheet Submission Report | CP           | CP-QA      | All          | July 2024    |      1  |June 2024   |      6   |Suramit Pramanik       |Rejected    |2024-06-04 | Suramit   |
        
   
     
