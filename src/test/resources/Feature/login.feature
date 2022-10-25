@smoke @regression
Feature: Login the etsy Application
  User Story: As a user i should be able to login the application
    AC1: user logins with valid credentials and the welcome message should appear
    AC2: user tries to sign in with invalid credentials and gets error message

  Scenario: User inputs valid credentials
    Given user navigates to etsy main page
    When user clicks on login button
    And user enters valid email
    And user enters valid password
    Then welcome user message is displayed

  Scenario: User inputs invalid credentials
    Given user navigates to etsy main page
    When user clicks on login button
    And user enters invalid email
    And user enters invalid password
    Then error message is displayed
