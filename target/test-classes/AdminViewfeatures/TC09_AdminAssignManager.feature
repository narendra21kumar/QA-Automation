Feature: Navigate to Assign Manager Page of Admin View and Assign Manager
 
  Background: 
    Given User Should Log in to Timesheet Admin View for Assign Manager Page
@admin
  Scenario Outline: Verify Reports Page of Timesheet Admin View and Validate as per the Requirement
    Then click on Assign Manager Icon
    And Select Client from Client dropdown for Assign Manager Page for Admin View "<nameOfClient>"
    Then Select Team from Team dropdown for Assign Manager Page for Admin View "<nameOfTeam>"
    And Fill the Assign Details for AssignManager of Admin View
    Then Click on save button to save assignManager of Admin View

    Examples: 
      | nameOfClient      |nameOfTeam  |
      | Mercell           |   CTMS     |
