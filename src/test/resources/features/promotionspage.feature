Feature: Promotions are visible

  Scenario: Promotions are available under "Promotions" tab on the home page of Tesco
    Given I open Tesco home page
    And I click on cookies button
    When I click on the Promotions tab
    Then I should be on the Promotions page
