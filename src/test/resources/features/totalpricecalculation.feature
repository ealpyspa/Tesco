Feature: Total price of a few products is calculated correctly

  Scenario: Verify the total price calculation in the shopping basket
    Given I am on a Home page
    And I accept cookies
    And I select "Fruit&Vegetables" tab
    And I navigate to the "Fruits" tab
    And I select "All Fruits" sub tab
    And I add the following fruits to my shopping basket
      | Products | Price |
      | Banana   | 126   |
      | Orange   | 137   |
    When I view my shopping basket
    Then the total price displayed in the basket is "263"