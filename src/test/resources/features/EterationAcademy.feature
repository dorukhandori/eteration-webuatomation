# language: en
@academy
Feature: Eteration Academy Functionality
  
  Scenario: User should be able to view instructors on the Academy page
    Given user navigates to the Eteration Academy page
    When user clicks on the instructors page
    Then the instructor list should not be empty
    And the instructor count should be 8 