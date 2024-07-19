Feature: Login as Employee Role and Create Timesheet for Current Week 

  @employee
  Scenario Outline: Login as Employee Role and Create Timesheet for Current Week
    Given Login As Employee Role 
    When Click on Create TimeSheetPage
    And Select the current week date as an Employee
    And Enter the Task Description,Category & SubCategory and Hours Details "<SheetName>"
    And Click On Save, Submit & confirm button to Create the Timesheet
    Then Validate The TimeSheet Response As "<Successfully Submitted Message>"
    
  Examples:
      |       Successfully Submitted Message | SheetName                 |
      |   Timesheet already submitted!       |  EmployeeCreateTimeSheet  |

