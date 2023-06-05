Feature: Check detail of new sin
  As a sinner
  I want to check detail of my sin

  Background: I am on Sin City page
    Given I open sin city page
  @smoke @release
    Scenario: Confess new valid Sin without tags
      And I confess a valid Sin without tags
      When I open sin detail
      Then The information are correct
