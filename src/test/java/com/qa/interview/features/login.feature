Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given User is on the login screen
    When User opens the side menu
    When User enters valid username and password
    And User taps on the login button
    Then User should be logged in successfully

  Scenario: User logs in with invalid credentials
    Given User is on the login screen
    When User opens the side menu
    When User enters invalid username and password
    And User taps on the login button
    Then Validate error message

  Scenario: User logs in with No user name
    Given User is on the login screen
    When User opens the side menu
    When User enters valid password
    And User taps on the login button
    Then Validate error message username is required

  Scenario: User logs in with No password
    Given User is on the login screen
    When User opens the side menu
    When User enters valid username
    And User taps on the login button
    Then Validate error message Password is required

  Scenario: User logs in with locked account
    Given User is on the login screen
    When User opens the side menu
    When User enters valid username and password
    And User taps on the login button
    Then Validate error message user has been locked out
