Feature: Book Hotel
  Scenario: Search hotel
    Given user open goibibo website
    When user select hotel booking
    And user select country Type
    And user enters location "Chennai"
    And user select checkIn date "30 September 2024"
    And checkOut date "16 October 2024"
    And select number of rooms "2",adults "4" ,child "1" and child age is "2"
    Then user clicks on search
    And verify user is on hotels displayed page

    Scenario: Book the first hotel
      Given user open goibibo website
      When user select hotel booking
      And user enters location "Chennai"
      When user clicks on search
      And user clicks on first hotel displayed on the hotel search page
      And user clicks on select room Button
      And verify user is on property information page
      And user fills the guest details
      And user clicks on proceed to payment
      Then verify user is on payment page



  Scenario:Verify price of hotels are in low to high
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on price low to high
    Then verify the hotels displayed in price low to high order

  Scenario:Verify price of hotels are in high to low
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on price high to low
    Then verify the hotels displayed in price high to low order


