Feature: Category Dashboard Page in Admin View
@code
  Scenario: Admin Category Dashboard Page
  Given Login as Admin for Import Excel Page
  When click on Import Excel Icon in Admin view
  Then Validate title of the page for Import Excel Page