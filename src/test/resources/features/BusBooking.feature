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
    And user search Bus from "Calicut" and to "Ernakulam"
    And user select date "12 September 2024"
    And user clicks on search button of bus
    And user clicks on show buses Button if the bus is KSRTC
    And user clicks on select seat
    Then verify seats are visible
    When user select seat
    And user clicks on continue
    Then verify user is on booking review page
    When user fills the details
    And user clicks on the pay button
    Then verify user is on the payment page
    When user clicks on UPI options
    Then verify send payment request and QR option  is displayed
