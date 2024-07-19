Feature: Login as Employee Role to verify the Approved status of Timesheet

  Background: 
    Given Login as the Employee's Role

  @employee
  Scenario Outline: Login as Employee Role to verify the Approved status of Timesheet
    And Click on Approved Timesheet Icon
    Then Click on Expand Icon to Verify the Approved Status "<ApprovedStatus>"
   
    
 Examples: 
      | ApprovedStatus   |
      | Approved         |