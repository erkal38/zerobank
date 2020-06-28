Feature: Find Transactions in Account Activity

  Background:
    Given the user landed homepage
    Given the user clicks signing button
    Given the user logged in
    Given the user clicks Account Activity tab
    Given the user clicks the FindTransactions tab
    And the user clicks search

  Scenario: Search date range

    When the user enters date range from "2012-09-01" to "2012-09-06"
    And the user clicks search
    And the user checks results transaction following dates
      | 2012-09-01 |
      | 2012-09-02 |
      | 2012-09-03 |
      | 2012-09-04 |
      | 2012-09-05 |
      | 2012-09-06 |


  Scenario Outline: Search Description
    When the user enters description "<description>"
    Examples:
      | description |
      | ONLINE      |
      | OFFICE      |

  Scenario: Search Descriptions
    Then the user checks results description following definitons
      | ONLINE TRANSFER REF #UKKSDRQG6L |
      | ONLINE TRANSFER REF #UKKSDRQG6L |
@wip
  Scenario Outline: Search description case sensitive
    Given the user enters description "<definition>"
    Examples:
      | definition |
      | ONLINE     |
      | online     |
  @wip
    Scenario: Search description
    Then the user checks results description following definitons
      | ONLINE TRANSFER REF #UKKSDRQG6L |
      | ONLINE TRANSFER REF #UKKSDRQG6L |