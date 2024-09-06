Feature: Verify send notification mail for employee not submitted timesheet

Background:
Given Manager login into the timesheet view for employee not submitted timesheet

 @manager
Scenario Outline: Verify send notification mail for employee not submitted timesheet
						When Click on send notification page
						And Click on yes radio button for timesheet created
						And Check the header part checkbox for send email notification
					#	And Click on send email button
						