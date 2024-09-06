Feature: Reports timesheet details report

Background:
Given User login into the manager view for download the timesheet details report

@manager
Scenario Outline: User able to download the timesheet detail report
				When Click on reports page icon
				And Click on dropdown timesheet detail report
				And Click on export data dwonload icon
				