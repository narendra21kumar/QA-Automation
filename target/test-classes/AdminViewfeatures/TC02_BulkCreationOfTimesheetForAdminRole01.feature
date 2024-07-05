Feature: Admin able to Create Timesheet
 
Background:
		Given User login to Admin View for AdminBulkCreationOfTimesheet
    And click on Create Timesheet  icon for Admin View of Timesheet for AdminBulkCreationOfTimesheet
@admin
  Scenario Outline: Admin should be able to Create Timesheet
    #When Enter Start Month "<Startmonth>" and Enter Start date "<Startdate>" for Create Timesheet is for AdminBulkCreationOfTimesheet
    When Enter Date Value for "<DateValue>" for Create Timesheet is for AdminBulkCreationOfTimesheet
    Then Fill all mandatory fields "<sheetname>" for AdminBulkCreationOfTimesheet
    And Click on save and Confirm for AdminBulkCreationOfTimesheet
    
    Examples:
      #| Startmonth | Startdate |sheetname	  |
      #| July 2024  |        1  |	14th Week   |	
      #| July 2024  |        7  |	14th Week   |	
      
       |DateValue|sheetname|
       | 2       |14th Week|
       | 9       |14th Week|