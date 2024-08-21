Feature: Validating Holiday Booking

  Scenario: Verify booking for Handcrafted Honeymoon
    Given user open goibibo website
    When select holiday booking
    Then verify user is on holiday search page
    When user select handcrafted honeymoon holiday type
    Then verify user is on holiday packages page
    When user selects for destination package
    Then verify package page is shown
    When user selects from "Cochin" and date "22 October 2024"
    And user clicks the proceed to payment button
    Then verify user is on data filling page
    When user fills guest details
    Then verify user is on holidays payment page


