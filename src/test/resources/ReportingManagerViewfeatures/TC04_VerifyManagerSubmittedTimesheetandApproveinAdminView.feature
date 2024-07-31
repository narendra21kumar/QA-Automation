Feature: Verify the manager submitted timesheet and approve from admin view

Background:
			Given verify the manager submitted timesheet and approve from admin view
@manager
Scenario Outline: Admin can be able to verify the manager submitted timesheet and approve
					When Click on submitted timesheet management icon
					And  Select current week date
					Then  Validate the status "<empid>" of the submitted timesheet based on emp id "<status>"
					And   Click on approve timesheet icon based on empid "<empid>"
					Then  validate the toast message as "<toastmessagge>" 
					
					Examples:
					|  empid  |  status			  |          toastmessagge										          |
					|    189  |  Submitted	  |			Timesheet approved successfully!								|
					 