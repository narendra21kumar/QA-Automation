Feature: Hr Assign/Manager Page

@admin
  Scenario Outline: Assign/Manager Page In Hr
    Given Login to Timesheet for Assign Manager for Hrview
    When  Click on Assign Manager Icon in Hr View
    And   Select Client from Client dropdown for Assign Manager Page in Hr View "<nameOfClient>"
    And   Select Team from Team dropdown for Assign Manager Page in Hr View "<nameOfTeam>"
    Then  Validate title of the page for AssignManager in Hr view

    Examples: 
      | nameOfClient      |nameOfTeam  |
      | CP                |   CP       |
