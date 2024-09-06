Feature: Verify send notification mail for employee not submitted timesheet for admin

@code
Scenario:   Verify Send Notification page in admin view
            Given Login as Admin for send Notification page
						When Click on Send notification page for Admin view
						And Click on yes button for timesheet created for Admin view
						And Click on send email button for Admin view