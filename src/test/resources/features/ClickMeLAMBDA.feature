@smoke
@clickme
Feature: Click me baby
  As a user
  I want to click on button n-times
  For no reason at all, only for study purpose

  Scenario:  No click
    Given LAMBDA I am on click me baby page
    Then LAMBDA description is "klikov"

  Scenario:  Click on button once
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    Then LAMBDA description is "klik"

  Scenario:  Click on button twice
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    When LAMBDA I click on button
    Then LAMBDA description is "kliky"

  Scenario:  Click on button 3times
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    Then LAMBDA description is "kliky"

  Scenario:  Click on button 4times
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    Then LAMBDA description is "kliky"

  Scenario:  Click on button 5times
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    Then LAMBDA description is "klikov"

  Scenario:  Click on button 6times
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    When LAMBDA I click on button
    Then LAMBDA description is "klikov"

  Scenario Outline:  Click on button <clicksCount>
    Given LAMBDA I am on click me baby page
    When LAMBDA I click on buttonNTimes <clicksCount>
    Then LAMBDA Description is "<result>"
    Examples:
      | clicksCount | result |
      | 0           | klikov |
      | 1           | klik   |
      | 2           | kliky  |
      | 3           | kliky  |
      | 4           | kliky  |
      | 5           | klikov |
      | 6           | klikov |
      | 7           | klikov |


  Scenario:  Click on button once
    Given LAMBDA I am on click me baby page
    When LAMBDA I click 78 time on button
    Then LAMBDA description is "klikov"


  Scenario Outline:  Click on button <clicksCount>
    Given LAMBDA I am on click me baby page
    When LAMBDA I click <clicksCount> time<s> on button
    Then LAMBDA Description is "<result>"
    Examples:
      | clicksCount | result | s |
      | 0           | klikov |   |
      | 1           | klik   |   |
      | 2           | kliky  | s |
      | 3           | kliky  | s |
      | 4           | kliky  | s |
      | 5           | klikov | s |
      | 6           | klikov | s |
      | 7           | klikov | s |









