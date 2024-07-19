Feature:Login as Employee Role and Create Timesheet for Future Week

  @employee
  Scenario Outline: Login as Employee Role and Create Timesheet for Future Week
    Given Login As Employee Role
    When Click on Create TimeSheetPage
    And Select the Future week Date from Calender Icon
    And Enter the Task Description,Category & SubCategory and Hours Details "<SheetName>"
    And Click On Save, Submit & confirm button to Create the Timesheet
 
    
  Examples:
      |       Successfully Submitted Message | SheetName            |
      |   Timesheet already submitted!       |  DuplicateTaskDisc   |


