Feature: Delete Admin Timesheet record For Current Week
 
   @admin
	 Scenario Outline: Admin Delete Timesheet record For Current Week
	   Given Login as Admin for Delete Admin Timesheet Record
     When Click On Create Timesheet Page for Admin delete functionality
     And  Select the Current Date In Admin View for delete functionality
     And  Click On Edit Icon and Add A Row Icon for delete functionality
     And  Click On Delete Icons for Delete Admin created TimeSheet
     Then Validate Deleted record and verify "<Successfully Deleted Message>" In Admin View
     
       	Examples:
     |   Successfully Deleted Message    |
     |   Task deleted successfully!      |