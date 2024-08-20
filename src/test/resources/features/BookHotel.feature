Feature: Book Hotel

  Scenario: Search hotel
    Given user open goibibo website
    When user select hotel booking
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

  Scenario:Verify rating of hotels are in descending order
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on customer rating
    Then verify the hotels displayed in descending order by customer rating


  Scenario Outline:Verify country type is automatically selected by enter city
    Given user open goibibo website
    When user select hotel booking
    And user enter location "<city>"
    Then verify "<selected_country_Type>" is selected with respect to the city we entered
    Examples:
      | city   | selected_country_Type |
      | Mumbai | India                 |
      | London | International         |


  Scenario Outline:Verify property type are displayed on search page when we filter by property type
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on "<property>"
    Then verify "<property>" are displayed in search page

    Examples:
      | property  |
      | Apartment |
      | Villa     |
      | Hotel     |

  Scenario Outline:Verify popular filters are working properly
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Bangalore"
    When user clicks on search
    And verify user is on hotels search page
    And user clicks on "<popular_filters>"
    Then verify respected filters "<output>" are displayed in search page

    Examples:
      | popular_filters               | output                                |
      | Couple-friendly Stays         | Couple Friendly                       |
      | Free Cancellation Available   | Free Cancellation Till Checkin        |
      | Free Breakfast Included       | INCL OF FREE BREAKFAST                |
      | Breakfast Included            | INCL OF FREE BREAKFAST                |
      | Breakfast and Dinner Included | INCL OF FREE BREAKFAST + LUNCH/DINNER |
      | All Meals Available           | INCL OF ALL MEALS                     |





