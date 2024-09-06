Feature: Reports timesheet submission report

Background:
Given User login into the manager view for download the timesheet submission report

@manager
Scenario Outline: User able to download the timesheet submission report
				When Click on reports icon
				And Click on dropdown icon
				And Click on export data icon
				Then validate the totalhours "<ModifiedBy>" on header part
			Examples:
			|ModifiedBy|
			|ModifiedBy|