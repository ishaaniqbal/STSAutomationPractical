Feature: LoginSteps

  Scenario: Successful Login with valid credentials
    Given User is on the login page
    When User enters valid credentials
    Then User should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters invalid credentials
    Then User should see an error message
