Feature: Login as Employee Role to verify the Pending status of Timesheet

  Background: 
    Given Login as the Employee Role

  @employee
  Scenario Outline: Login as Employee Role to verify the Pending status of Timesheet
    When Click on Pending Icon
    Then Click on Expand Icon to Verify the pending Status "<PendingStatus>"
    
 Examples: 
      | PendingStatus  |
      | Pending        |