Feature:

  Background: Login


  Scenario: Account Summary types
    Given the user logged in
    Then the account summary following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then the "Credit Accounts" section should contain following titles
      | Account     |
      | Credit Card |
      | Balance     |

