Feature: Admin able to verify pending Timesheet
 
Background:
   Given Admin login for pending for Managerview for adminView
   
@admin
	Scenario Outline: Admin able to verify pending Timesheet
   Then click pending Timesheet page and click on WeekstartDate "<weekStartDate>" for adminView
   
   Examples:
      | weekStartDate     |
      |    	07 Jul 2024   |