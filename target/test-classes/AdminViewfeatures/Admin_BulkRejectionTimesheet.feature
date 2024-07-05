Feature: Bulk Rejection and verify in admin view
 
  Background:
    Given User Admin timesheet page for BulkRejection
 
  @bulk
  Scenario Outline: Bulk Rejection and verify in admin view
    And Select the <Startdate> and <EndDate> for rejection
    And search by "<name>" and click on checkBox for rejection
   	And Reject the timesheet by filling the Remarks as "<BulkRejection>" In adminView
   	Examples:
      | Startdate  | EndDate | name  |BulkRejection   |
      |        1   |    30   |   Jam | BulksRejection |