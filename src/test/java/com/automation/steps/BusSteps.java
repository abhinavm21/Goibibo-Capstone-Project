package com.automation.steps;


import com.automation.pages.BusPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusSteps {

    BusPage busPage=new BusPage();

    @When("user select bus booking")
    public void userSelectBusBooking() {
        busPage.clickOnBus();
    }

    @And("user search Bus from {string} and to {string}")
    public void userSearchBusFromAndTo(String from, String to) {
        busPage.searchForBus(from,to);
    }

    @And("user select date {string}")
    public void userSelectDate(String date) {
        busPage.selectDate(date);

    }

    @And("user clicks on search button of bus")
    public void userClicksOnSearchButtonOfBus() {
        busPage.clickOnSearch();

    }

    @Then("verify user is on Bus search page")
    public void verifyUserIsOnBusSearchPage() {
        Assert.assertTrue(busPage.busSearchPageIsDisplayed());

    }

    @And("user clicks on show buses Button if the bus is KSRTC otherwise select seat directly")
    public void userClicksOnShowBusesButtonIfTheBusIsKSRTCOtherwiseSelectSeatDirectly() {

        busPage.selectKSRTCBus();

    }

    @And("verify seats are visible")
    public void verifySeatsAreVisible() {

        Assert.assertTrue(busPage.seatsAreDisplayed());
    }

    @When("user select seat")
    public void userSelectSeat() {
      busPage.selectSeat();
    }

    @Then("verify continue button is displayed")
    public void verifyContinueButtonIsDisplayed() {
          Assert.assertTrue(busPage.continueBtnIsDisplayed());
    }

    @When("user select boarding point and dropping point and clicks on continue")
    public void userSelectBoardingPointAndDroppingPointAndClicksOnContinue() {
        busPage.clickOnContinue();
    }

    @Then("verify user is on booking review page")
    public void verifyUserIsOnBookingReviewPage() {
        Assert.assertTrue(busPage.reviewOfBookingTextIsDisplayed());
    }

    @When("user fills the details")
    public void userFillsTheDetails() {
        busPage.fillsDetailsOfBusTraveller();
    }

    @And("user clicks on the pay button")
    public void userClicksOnThePayButton() {
        busPage.clickOnPayButton();
    }

    @Then("verify user is on the payment page")
    public void verifyUserIsOnThePaymentPage() {
        Assert.assertTrue(busPage.paymentPageDisplayed());
    }


    @When("user clicks on UPI options")
    public void userClicksOnUPIOptions() {
        busPage.clickOnUPIOptions();
    }


    @Then("verify send payment request and QR option  is displayed")
    public void verifySendPaymentRequestAndQROptionIsDisplayed() {
        Assert.assertTrue(busPage.paymentRequestAndQROptionIsDisplayed());
    }

    @When("user clicks on location changer")
    public void userClicksOnLocationChanger() {
        busPage.clickOnLocationChanger();
    }

    @Then("verify source and destination is interchanged by {string} to {string}")
    public void verifySourceAndDestinationIsInterchangedByTo(String source, String destination) {
        Assert.assertTrue(busPage.locationsInterchanged(source,destination));
    }

    @Then("verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue(busPage.errorMsgDisplayed());
    }


    @And("user clicks on rating")
    public void userClicksOnRating() {
        busPage.clickOnRating();
    }

    @Then("verify rating is in descending order")
    public void verifyRatingIsInDescendingOrder() {
        Assert.assertTrue(busPage.ratingsInDescendingOder());
    }

    @When("again user clicks on rating")
    public void againUserClicksOnRating() {
        busPage.clickOnRatingAscending();
    }

    @Then("verify  rating is in ascending order")
    public void verifyRatingIsInAscendingOrder() {

        Assert.assertTrue(busPage.ratingsInAscendingOder());
    }


    @And("user clicks on Departure")
    public void userClicksOnDeparture() {
        busPage.clickOnDepartureAsc();
    }

    @Then("verify departure is in ascending order")
    public void verifyDepartureIsInAscendingOrder() {

        Assert.assertTrue(busPage.departureInAscendingOrder());
    }

    @When("again user clicks on Departure")
    public void againUserClicksOnDeparture() {
        busPage.clickOnDepartureDesc();
    }

    @Then("verify  Departure is in descending order")
    public void verifyDepartureIsInDescendingOrder() {
        Assert.assertTrue(busPage.departureInDescendingOrder());
    }

    @And("user clicks on Arrival")
    public void userClicksOnArrival() {
        busPage.clickOnArrivalAsc();
    }

    @Then("verify Arrival is in ascending order")
    public void verifyArrivalIsInAscendingOrder() {
        Assert.assertTrue(busPage.arrivalInAscendingOrder());
    }

    @When("again user clicks on Arrival")
    public void againUserClicksOnArrival() {
        busPage.clickOnArrivalDesc();
    }

    @Then("verify  Arrival is in descending order")
    public void verifyArrivalIsInDescendingOrder() {
        Assert.assertTrue(busPage.arrivalInDescendingOrder());
    }

    @And("user clicks on cheapest")
    public void userClicksOnCheapest() {
        busPage.clickOnCheapestAsc();
    }

    @Then("verify ticket price is in ascending order")
    public void verifyTicketPriceIsInAscendingOrder() {
        Assert.assertTrue(busPage.priceInAscendingOrder());
    }

    @When("again user clicks on cheapest")
    public void againUserClicksOnCheapest() {
        busPage.clickOnCheapestDesc();
    }

    @Then("verify  ticket price is in descending order")
    public void verifyTicketPriceIsInDescendingOrder() {
        Assert.assertTrue(busPage.priceInDescendingOrder());
    }



}
