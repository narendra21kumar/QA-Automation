Feature: Delete Admin Timesheet record For Previous Week
   @admin
	 Scenario Outline: Admin Delete Timesheet record For Previous Week
	   Given Login as Admin for Delete Admin Timesheet Record
     When  Click On Create Timesheet Page for Admin delete functionality
     And   Select the Previous Date In Admin View for delete functionality
     And   Click On Edit Icon and Add A Row Icon for delete functionality
     And   Click On Delete Icons for Delete Admin created TimeSheet
     Then  Validate Deleted record and verify "<Successfully Deleted Message>" In Admin View
     
       	Examples:
     |   Successfully Deleted Message    |
     |   Task deleted successfully!      |