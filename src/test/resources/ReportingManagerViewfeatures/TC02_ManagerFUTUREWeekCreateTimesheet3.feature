Feature: Manager Able To Create Timesheet For Future Week
 
	Background:
			Given User Can Able To Login Into The Manager View For Create Timesheet
  @ManagerView
	 Scenario Outline:Manager Able To Create Timesheet For Future Week
	
     And Click On Create Timesheet Icon In Manager View
     And Select the Future Date In Manager view From Calender Icon
     And Enter The Task Discription,Select The Category,Subcategory And Entering Hours To Create Current Week Timesheet "<SheetName>"
     And Click On Save And Submit confirm The Timesheet
     Then Validate The TimeSheet Response As "<Successfully Submitted Message>"
     
       	Examples:
     |       Successfully Submitted Message | SheetName    |
     |   Timesheet already submitted!       |  14th Week   |