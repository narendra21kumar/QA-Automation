Feature: Manager Able To Create Timesheet For Current Week
 
	Background:
			Given User Can Able To Login Into The Manager View For Create Timesheet
  @ManagerView
	 Scenario Outline:Manager Able To Create Timesheet For Current Week
	
     And Click On Create Timesheet Icon In Manager View
     And Enter The Task Discription,Select The Category,Subcategory And Entering Hours To Create Current Week Timesheet "<SheetName>"
     And Click On Save And Submit confirm The Timesheet
     Then Validate The TimeSheet Response As "<Successfully Submitted Message>"
     
       	Examples:
     |       Successfully Submitted Message | SheetName    |
     |   Timesheet already submitted!       |  14th Week   |