Feature: Verify the manager submitted timesheet and reject from admin view

Background:
			Given verify the manager submitted timesheet and reject from admin view
@manager
Scenario Outline: Admin can be able to verify the manager submitted timesheet and reject
					When Click on the submitted timesheet management icon
					And  Select previous week date
				 	Then  Validate the submitted timesheet based on emp id "<empid>" and the status "<status>" 
				  And   Click on the reject timesheet icon based on empid "<empid>" and enter the remarks "<remarks>"
				  Then  validate the toast message response  as "<toastmessage>" 
					
					Examples:
					|  empid  |  status			  |remarks|          toastmessage													      |
					|    189  |  Submitted	  |Test		|			Timesheet rejected successfully!								|
					 