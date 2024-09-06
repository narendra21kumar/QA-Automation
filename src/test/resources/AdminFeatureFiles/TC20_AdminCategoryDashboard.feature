Feature: Category Dashboard Page in Admin View
@code
  Scenario: Admin Category Dashboard Page
  Given Login as Admin for Category Dashboard
  When Click on Category Dashboard Page icon in Admin View
  Then Validate title of the page for Category Master