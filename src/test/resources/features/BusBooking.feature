Feature: Verify the functionalities of Bus Booking

  Background:
    Given user open goibibo website
    When user select bus booking

  Scenario: Search Bus
    And user search Bus from "Calicut" and to "Ernakulam"
    And user select date "12 September 2024"
    And user clicks on search button of bus
    Then verify user is on Bus search page

  Scenario: Book the first Bus
    And user search Bus from "Bangalore" and to "Mumbai"
    And user select date "12 September 2024"
    And user clicks on search button of bus
    And user clicks on show buses Button if the bus is KSRTC otherwise select seat directly
    Then verify seats are visible
    When user select seat
    Then verify continue button is displayed
    When user select boarding point and dropping point and clicks on continue
    Then verify user is on booking review page
    When user fills the details
    And user clicks on the pay button
    Then verify user is on the payment page
    When user clicks on UPI options
    Then verify send payment request and QR option  is displayed


  Scenario: Verify location changer is working
    And user search Bus from "Thrissur" and to "Ernakulam"
    When user clicks on location changer
    Then verify source and destination is interchanged by "Ernakulam" to "Thrissur"

  Scenario: Verify that travel from and to locations should not be same
    And user search Bus from "Thrissur" and to "Thrissur"
    When user clicks on search button of bus
    Then verify error message is displayed


  Scenario: Verify rating is in descending and ascending order
    And user search Bus from "Bangalore" and to "Mumbai"
    When user clicks on search button of bus
    And user clicks on rating
    Then verify rating is in descending order
    When again user clicks on rating
    Then verify  rating is in ascending order

  Scenario: Verify departure time is displayed in early(ascending) and late(descending) order
    And user search Bus from "Bangalore" and to "Mumbai"
    When user clicks on search button of bus
    And user clicks on Departure
    Then verify departure is in ascending order
    When again user clicks on Departure
    Then verify  Departure is in descending order

  Scenario: Verify arrival time is displayed in early(ascending) and late(descending) order
    And user search Bus from "Bangalore" and to "Mumbai"
    When user clicks on search button of bus
    And user clicks on Arrival
    Then verify Arrival is in ascending order
    When again user clicks on Arrival
    Then verify  Arrival is in descending order


  Scenario: Verify price of ticket is displayed in low price(ascending) and high price(descending) order
    And user search Bus from "Bangalore" and to "Mumbai"
    When user clicks on search button of bus
    And user clicks on cheapest
    Then verify ticket price is in ascending order
    When again user clicks on cheapest
    Then verify  ticket price is in descending order



