Feature: Verify manager timesheet having more than 12 hours in each day
 
  Background:
    Given Manager login into the timesheet for time validation
 
  @manager
  Scenario Outline: Verify manager timesheet having more than 12 and 24 hours in each day
    When Click on create timesheet page
    And Select the future date from calendar
    And Enter timehseet details "<sheetName>"
    And Click on saveall icon
    Then Validate error is displaying for more than twenty four hours per day "<Error Message>"
   	 Examples:
      |              Error Message                                | sheetName         |
      |  Summation of hours in mon tue wed thu fri exceeded 24!!! |  24HoursPerDay    |