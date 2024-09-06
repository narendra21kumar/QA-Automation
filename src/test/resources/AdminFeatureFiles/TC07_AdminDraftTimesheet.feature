Feature: Admin Draft Timesheet Functionality
@code
  Scenario: Admin Record is in Draft after being self rejected
  Given Login as Admin for Draft Functionality
  When  Click on Create timesheet icon for draft functionality
  And   Select the Past week date for Admin draft functionality
  Then  Validate is record is being saved and submitted
 
