# language: en
@homepage @academy
Feature: Eteration Homepage Functionality
  
  Scenario: User should be able to successfully access the homepage
    Given user navigates to the homepage
    Then the page title should contain "Eteration"
    And the Eteration logo should be displayed 