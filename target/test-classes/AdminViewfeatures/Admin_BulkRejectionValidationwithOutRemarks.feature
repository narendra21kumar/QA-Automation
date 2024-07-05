Feature: Bulk Rejection and verify validation Error withoutRemarks in admin view
 
  Background:
    Given User Admin timesheet page for BulkRejection
 
  @bulk
  Scenario Outline: Bulk Rejection and verify validation Error withoutRemarks in admin view
    And Select the <Startdate> and <EndDate> for rejection
    And search by "<name>" and click on checkBox for rejection
   	And Verify the validation "<String>" by Rejecting the timesheet by without filling the Remarks as  In adminView
   	Examples:
      | Startdate  | EndDate | name  |BulkRejection   |Validation Error                                   |
      |        1   |    30   |   Jam |                |Please enter the remarks for rejecting timesheet !|