Feature: Login to Website with Unsafe URL and Launch Page Using Microsoft Account

  Background: 
    Given I am on the login page of the websites for manager view

  @manager
  Scenario: Access website with Unsafe URL and login with valid credentials
    And Click on "Advanced" options for manager view
    And Select the option to proceed to the unsafe URLs for manager view
    Then Redirected to the login page and verify the title for manager view
