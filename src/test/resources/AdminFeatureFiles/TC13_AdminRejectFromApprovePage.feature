Feature: Reject Timesheet Records from Approved Page in Admin
@admin
  Scenario: Reject Admin Self Timesheet records from Approved Page in Timesheet
    Given Login as Admin for Self Reject in Approved Page
    And   Click on Approve Icon for Admin Self Reject in Approved Page
    And   Enable the Show Self Timesheet button for Admin Self Reject in Approved Page
    And   Click on checkbox for Admin Self Reject in Approved Page
    And   Reject the timesheet by providing Remarks as "<BulkRejection>" In adminView in Approve page