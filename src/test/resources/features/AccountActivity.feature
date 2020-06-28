
Feature: Navigating to specific Account Activity Page
  Background:
    Given the user landed homepage
    Given the user clicks signing button
    Given the user logged in


  Scenario Outline: <accountType> account redirect
    When the user click "<accountType>" link on	the	Account	Summary	page
    Then the "<title>"should displayed
    Then the account dropdown "<accountType>" selected
    Then the title should be "Zero - Account Activity"
    Examples:
      | accountType | title        |
      | Savings     | Account Activity |
      | Checking    | Account Activity |
      | Loan        | Account Activity |
      | Credit Card | Account Activity |
      | Brokerage   | Account Activity |
