#Flaky test, it depends on the prices on the website
Feature: Total price of a  few products is calculated correctly
@TotalPrice
  Scenario: Verify the total price calculation in the shopping basket
    Given I am on a Home page
    And I accept cookies
    And I am logged in
    And I select Fruit&Vegetables tab
    And I select all Fruit&Vegetables tab
    And I add the first product to my shopping basket
    And I add the second product to my shopping basket
    When I check the basket
    Then the total price displayed in the basket is "257"