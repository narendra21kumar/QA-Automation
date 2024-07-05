Feature: Verify Duplicate Task Description in Employee view
 
  Background:
    Given User login timesheet page
 
  @employee
  Scenario: Duplicate Task Description in Employee view
    When Enter task Description and Click On save
   	Then validate task Description