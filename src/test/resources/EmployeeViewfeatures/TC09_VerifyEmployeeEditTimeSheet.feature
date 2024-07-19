Feature: Login as Employee Role to verify the Edit Functionality

  Background: 
    Given Log In as Employee Role

  @employee
  Scenario Outline: Login as Employee Role to verify the Edit Functionality
    When Click on Create TimeSheet Icon 
    And Select the Week for draft Timesheet
    And Click on edit icon
   	And Edit the TimeSheet Details and Submit "<SheetName>"
   
    
  Examples:
      |       Successfully Submitted Message | SheetName                  |
      |   Timesheet already submitted!       |  EmployeeCreateTimeSheet   |
   	
   	
   	