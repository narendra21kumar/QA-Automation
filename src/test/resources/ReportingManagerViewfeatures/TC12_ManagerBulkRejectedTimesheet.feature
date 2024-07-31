Feature: Bulk rejected timesheets in timesheet management page for manager view
 
  Background:
    Given User login into the manager view for bulk rejected timesheets in timesheet management page 
 
  @manager
  Scenario Outline: Bulk rejected timesheets in manager view
    When Click on submitted icon 
   	And Check header part checkbox
   	And Click on reject button and enter the "<remarks>" in remarks text field click on confirm button
   	Then Validate the bulk rejected timesheet response as "<timesheet rejected sucessfully>" and "<no records to display>"
   	
   	Examples:
   	|timesheet rejected sucessfully   |       no records to display							|remarks|
   	|Timesheet rejected successfully! |				No records to display							|Test		|