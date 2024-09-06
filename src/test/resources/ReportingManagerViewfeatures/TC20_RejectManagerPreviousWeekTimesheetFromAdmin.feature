Feature: Reject the manager submitted timesheet from admin view

Background:
			Given Admin login into the timesheet and reject the manager submitted timesheet
@manager
Scenario Outline: Reject the manager submitted timesheet from admin view
					When Click on timesheet icon in admin view
					And  Select previous week date from calendar in admin view
					And Click on timesheet management icon based on empid "<empid>" and enter the remarks "<remarks>" in text field
				
					
					Examples:
					|	empid	    |	remarks	|
					|	123451  	|	Test   	|