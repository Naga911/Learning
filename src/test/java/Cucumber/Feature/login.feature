@WeHere
Feature: Verification of PAW Application

  Scenario:Logging into application
    Given Entering username and password
    And On Successful login user should be navigated to Home Screen
    When Clicked on submit button


  Scenario:Registration of user details
    Given Entering mandatory fields
    Then Clicking on submit button
    And User navigated to Landing Home page

