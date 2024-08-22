Feature: Verify the functionalities of Bus Booking

  Scenario: Search Bus
    Given user open goibibo website
    When user select bus booking
    And user search Bus from "Calicut" and to "Ernakulam"
    And user select date "12 September 2024"
    And user clicks on search button of bus
    Then verify user is on Bus search page

  Scenario: Book the first Bus
    Given user open goibibo website
    When user select bus booking
    And user search Bus from "Thrissur" and to "Ernakulam"
    And user select date "12 September 2024"
    And user clicks on search button of bus
    And user clicks on show buses Button if the bus is KSRTC otherwise select seat directly
    Then verify seats are visible
    When user select seat
    And user clicks on continue
    Then verify user is on booking review page
    When user fills the details
    And user clicks on the pay button
    Then verify user is on the payment page
    When user clicks on UPI options
    Then verify send payment request and QR option  is displayed


  Scenario: Verify location changer is working
    Given user open goibibo website
    When user select bus booking
    And user search Bus from "Thrissur" and to "Ernakulam"
    When user clicks on location changer
    Then verify source and destination is interchanged by "Ernakulam" to "Thrissur"

  Scenario: Verify that travel from and to locations should not be same
    Given user open goibibo website
    When user select bus booking
    And user search Bus from "Thrissur" and to "Thrissur"
    When user clicks on search button of bus
    Then verify error message is displayed


  Scenario: Verify rating is in descending and ascending order
    Given user open goibibo website
    When user select bus booking
    And user search Bus from "Bangalore" and to "Mumbai"
    When user clicks on search button of bus
    And user clicks on rating
    Then verify rating is in descending order
    When again user clicks on rating
    Then verify  rating is in ascending order


