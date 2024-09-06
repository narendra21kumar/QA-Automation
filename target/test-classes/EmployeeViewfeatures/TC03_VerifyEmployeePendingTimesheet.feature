Feature: Login as Employee Role to verify the Pending status of Timesheet

  Background: 
    Given Login as the Employee Role

  @employee
  Scenario Outline: Login as Employee Role to verify the Pending status of Timesheet
    When Click on Pending Icon
    Then Click on Expand Icon to Verify the pending Status "<PendingStatus>"
    Then Verify the manager name "<managername>" and approver name "<approvername>" for employee in pending page
    
 Examples: 
      | PendingStatus  | 	managername										|     approvername												    	|
      | Pending        | Manager Name :Test 02					|      Approver Name :Cavungal Reema Simon John	|
      
    				   	