Feature: Reject the manager approved timesheet from admin view

Background:
			Given Admin login into the timesheet and reject the manager approved timesheet
@manager
Scenario Outline: Reject the manager approved timesheet from admin view
					When Click on approved icon in admin view
					And  Select current week date from calendar in admin view
					And Click on rejected timesheet icon based on empid "<empid>" and enter the remarks "<remarks>" in text field
					
					
					Examples:
					|	empid	    |	remarks	|
					|	123451  	|	Test   	|