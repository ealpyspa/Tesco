Feature: Home page loads
@HomePage
  Scenario: The Tesco home page loads

    Given I open Tesco website
    And I accept all cookies
    When I check the title of the page
    Then I see the Tesco home page
