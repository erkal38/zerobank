

Feature:
  Background:
    Given the user landed homepage
  Scenario: Account summary redirect
    When the user clicks signing button
    When the user logs in with correct credentials
    Then the title should be "Zero - Account Summary"
