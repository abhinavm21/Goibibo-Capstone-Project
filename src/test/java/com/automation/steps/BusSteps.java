package com.automation.steps;


import com.automation.pages.BasePage;
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

    @And("user clicks on show buses Button if the bus is KSRTC")
    public void userClicksOnShowBusesButtonIfTheBusIsKSRTC() {

        busPage.selectKSRTCBus();
    }

    @And("user clicks on select seat")
    public void userClicksOnSelectSeat() {
         busPage.clickOnSelectSeat();
    }

    @And("verify seats are visible")
    public void verifySeatsAreVisible() {

        Assert.assertTrue(busPage.seatsAreDisplayed());
    }

    @When("user select seat")
    public void userSelectSeat() {
      busPage.selectSeat();
    }

    @And("user clicks on continue")
    public void userClicksOnContinue() {
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

    @Then("verify send payment request is displayed")
    public void verifySendPaymentRequestIsDisplayed() {

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
}
