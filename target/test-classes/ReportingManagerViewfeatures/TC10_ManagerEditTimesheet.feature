Feature: Edit TimeSheet and Verify

  Background: 
    Given User login to the timesheet page for edit timesheet

  @manager
  Scenario Outline: verify the edit timesheet functionality
    When Click on create timeSheet icon 
    And  Select the draft timesheet previous date
    And  Click on edit icon in manager view
   	And  Edit the timesheet details "<sheetName>"
   	And  Click on save and submit
   	And  Click on Confirm 
   	Then Validate the edit timesheet response as "<Successfully Submitted Message>"
   	
   	
       	Examples:
     |       Successfully Submitted Message | sheetName      										 |
     |   Timesheet already submitted!       |  ManagerView_Edit_Data					   |
   	
   	