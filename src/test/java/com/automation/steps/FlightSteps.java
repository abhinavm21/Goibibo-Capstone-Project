package com.automation.steps;

import com.automation.pages.FlightPage;
import com.automation.pages.FlightSearchPage;
import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightSteps {

    HomePage homePage=new HomePage();
    FlightPage flightPage=new FlightPage();
    FlightSearchPage flightSearchPage=new FlightSearchPage();

    @Then("error message should be displayed for same location")
    public void error_message_should_be_displayed_for_same_location() {

        Assert.assertEquals(flightPage.errorMessageIsDisplayed(),"source and destination cannot be same");
    }

    @Then("verify user is on flight search page")
    public void verifyUserIsOnFlightSearchPage() {
        Assert.assertTrue(flightSearchPage.flightSearchPageIsDisplayed());
    }

    @When("user search flight from {string} and to {string}")
    public void userSearchFlightFromAndTo(String from, String to) throws InterruptedException {
        flightPage.searchForFlight(from,to);

    }

    @And("select departure date {string}")
    public void selectDepartureDate(String date) {
        flightPage.selectDepartureDate(date);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        flightPage.clickOnSearchBtn();
    }

    @When("user enters same location for from {string} and to field {string} for flight")
    public void userEntersSameLocationForFromAndToFieldForFlight(String from, String to) throws InterruptedException {
        flightPage.searchForFlight(from,to);
    }

    @And("verify user can see flights on flight search page")
    public void verifyUserCanSeeFlightsOnFlightSearchPage() {
        Assert.assertTrue(flightPage.viewFareIsDisplayed());
    }
}
