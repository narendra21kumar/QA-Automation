Feature: Verify Employee Timesheet having more than 12 hours per day
 
  Background:
    Given Login As Employee role
 
  @employee
  Scenario Outline: Verify Employee Timesheet having more than 12 hours per day
     When Click on create TimeSheetPage
     And Select the Future Week Date from Calender Icon
     And Enter task desc and hours "<SheetName>"
     And Click On save button in employeeView
   	 Then Validate error is displaying for more then 24 hours per day "<Error Message>"
   	 Examples:
      |              Error Message                                          | SheetName                      |
      |  Summation of hours in mon tue wed thu fri exceeded 24!!!           |  EmployeeView_24HoursPerDay    |