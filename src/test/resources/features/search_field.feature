Feature: Search functionality
@SearchField
  Scenario Outline: Searching for a product using the search field
    Given I am on the Tesco homepage
    And I click on accept cookies button
    When I enter '<product>' into the search field
    And I click on the search button
    Then the URL should contain '<product>'

    Examples:
      | product |
      | bread   |
      | milk    |