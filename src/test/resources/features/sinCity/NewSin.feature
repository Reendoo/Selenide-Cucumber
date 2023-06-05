Feature: Confess new sin
  As a sinner
  I want to confess a sin
  So that I have a clear conscience

  Background: I am on Sin City page
    Given I open sin city page
#    Given I am on sin city page

@test
  Scenario: Confess new valid Sin without tags
    And I enter sin author "Rendo"
    And I enter sin title "Murder 123"
    And I enter sin message "Kill I.M. and R.F. by Teaspoon."
    When I confess my sin
    Then My sin appears in the list of all sins "Murder 123"
@release
  @smoke
  Scenario: Confess new valid Sin with 1 tag
    And I enter sin author "Rendo"
    And I enter sin title "Murder 123 - beta"
    And I enter sin message "Kill I.M. and R.F. by Teaspoon."
    And I choose tag "robbery"
    When I confess my sin
    Then My sin appears in the list of all sins "Murder 123 - beta"

    @ignore
  Scenario: Confess new Sin without title
    And I enter sin author "Rendo"
    And I enter sin title "Murder 1234 - beta"
    And I enter sin message "Kill I.M. and R.F. by Teaspoon."
    And I select following sins
      | murder | robbery | car accident|
    When I confess my sin
    Then My sin appears in the list of all sins "Murder 1234 - beta"
@smoke
  Scenario: Confess new Sin without title
    And I enter sin title "He missed the penalty", author "Ramos"  I enter sin message "He shots up to orbit"
    And I select following sins
      | murder | robbery | car accident|
    When I confess my sin
    Then My sin appears in the list of all sins "Murder 1234 - beta"
