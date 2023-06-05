#language: nl
Functionaliteit:  Banana shop
  As a user I would like to get information about price of bananas

  Scenario: Check banana price
    Given I am on banana shop page
    En price for one banana is 1.5
    En I have chosen 1 banana
    Gegeven values in table are following
      | total_price           | 1.5  |
      | number_of_bananas     | 1    |
      | discount              | 0.00 |
      | price_before_discount | 1.5  |


