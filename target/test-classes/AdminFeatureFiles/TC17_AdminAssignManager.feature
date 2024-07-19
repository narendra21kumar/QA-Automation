Feature: Admin Assign/Manager Page

@admin
  Scenario Outline: Assign/Manager Page In Admin
    Given Login to Timesheet for Assign Manager
    When  Click on Assign Manager Icon
    And   Select Client from Client dropdown for Assign Manager Page in Admin View "<nameOfClient>"
    And   Select Team from Team dropdown for Assign Manager Page in Admin View "<nameOfTeam>"
    Then  Validate title of the page for AssignManager

    Examples: 
      | nameOfClient      |nameOfTeam  |
      | CP                |   CP       |
