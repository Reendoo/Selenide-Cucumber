Feature: Registration

  Background: Open registration page and enter basic user data
    Given I am on the registration page
    And I enter valid email, name, surname
    And I check robot checkbox


  Scenario: Registration with invalid password
    When I enter invalid password
    And I repeat invalid password
    And I click on registration button
    Then The registration fails

  Scenario: Registration with valid password
    When I enter a repeat valid password
    And I click on registration button
    Then The registration succeeds
