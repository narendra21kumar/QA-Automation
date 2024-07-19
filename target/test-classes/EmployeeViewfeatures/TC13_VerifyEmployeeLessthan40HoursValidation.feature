Feature:Verify Employee Timesheet having less than 40 hours for complete week
 
  Background:
    Given Login As Employee role
 
  @employee
  Scenario Outline: Verify Employee Timesheet having less than 40 hours for complete week
     When Click on create TimeSheetPage
     And Select the Future Week Date from Calender Icon
     And Enter task desc and hours "<SheetName>"
     And Click On save submit button in employeeView
   	 Then Validate error is displaying for less then 40 hours per week "<Error Message>"
   	 
   	 Examples:
      |              Error Message                                | SheetName           |
      |  Minimum 40 hours required to submit the timesheet        |  LessThen40Hours    |
