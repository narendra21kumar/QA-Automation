	Feature:Login as Employee Role and Create Timesheet for Past Week

 @employee
  Scenario Outline: Login as Employee Role and Create Timesheet for Past Week
    Given Login As Employee Role  
    When Click on Create TimeSheetPage
    And Select the Previous week Date from Calender Icon
    And Enter the Task Description,Category & SubCategory and Hours Details "<SheetName>"
    And Click On Save, Submit & confirm button to Create the Timesheet
    Then Validate The TimeSheet Response As "<Successfully Submitted Message>"
    
  Examples:
      |       Successfully Submitted Message | SheetName                  |
      |   Timesheet already submitted!       |  EmployeeCreateTimeSheet   |