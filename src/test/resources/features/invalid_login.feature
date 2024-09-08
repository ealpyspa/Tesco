Feature: Error message for invalid password
  @InvalidPassword
  Scenario: Error message appears when a valid email and an invalid password are entered

    Given I am on the main Tesco page
    And I push the cookies button
    And I click on the sign in button
    When I enter a valid email and invalid password
    Then I see the error message