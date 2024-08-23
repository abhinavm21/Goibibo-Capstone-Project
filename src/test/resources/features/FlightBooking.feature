Feature: validating flight search feature

	Scenario: user can search flight
		Given user open goibibo website
		When user search flight from "Chennai" and to "Bengaluru"
	    And select departure date "12 December 2024"
		And user clicks on search button
		Then verify user is on flight search page
		And verify user can see flights on flight search page


    Scenario: Verify that for one way trip from and to location should not be same
	    Given user open goibibo website
	    When user enters same location for from "Chennai" and to field "Chennai" for flight
		And user clicks on search button
	    Then error message should be displayed for same location

	Scenario: verify round trip is selected
		Given user open goibibo website
		When  user clicks on round-trip
		Then verify return date is displayed


	Scenario: verify multi-city is selected
		Given user open goibibo website
		When  user clicks on multi-city
		Then verify add another flight button is displayed
