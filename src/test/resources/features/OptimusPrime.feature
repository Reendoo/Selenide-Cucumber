@maximize
Feature: Optimus Prime
  As the Optimus
  I want tell you if number is prime or not

  Background:
    Given I am on the Optimus prime page

  Scenario Outline: Check the number <number>
    When I Enter number <number>
    And If i ask Optimus if it is prime
    Then Optimus says that number is <result>
    Examples:
      | number | result    |
      | 1      | prime     |
      | 3      | prime     |
      | 7      | prime     |
      | 11     | prime     |
      | 13     | prime     |
      | 6      | NOT prime |
      | 28     | NOT prime |
      | 100    | NOT prime |









