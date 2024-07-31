Feature: Verify manager timesheet having less than 40 hours for complete week
 
  Background:
    Given Manager login into the timesheet for verifying the less than fourty hours for complete week
 
  @manager
  Scenario Outline: Verify manager timesheet having less than 40 hours for complete week
     When Click on create timesheet icon page
     And  Select the future week date from calender icon
     And  Enter task description,category,subcategory and hours "<sheetName>"
     And  Click on save,submit and confirm button 
   	 Then Validate error is displaying for less then fourty hours per week "<Error Message>"
   	
   	 Examples:
      |              Error Message                                | sheetName           |
      |   Minimum 40 hours required to submit the timesheet       |  LessThen40Hours    |