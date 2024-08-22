package com.automation.steps;

import com.automation.pages.HotelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;

public class HotelSteps {

    HotelPage hotelPage = new HotelPage();

    @When("user select hotel booking")
    public void user_select_hotel_booking() {
        hotelPage.clickOnHotel();
    }


    @When("user enters location {string}")
    public void user_enters_location(String loc) throws InterruptedException {
        hotelPage.enterLocation(loc);

    }

    @And("user select checkIn date {string}")
    public void userSelectCheckInDate(String checkInDate) {

        hotelPage.selectCheckInDate(checkInDate);
    }

    @And("checkOut date {string}")
    public void checkoutDate(String checkOutDate) {
        hotelPage.selectCheckOutDate(checkOutDate);

    }

    @Then("user clicks on search")
    public void user_clicks_on_search() {

        hotelPage.clickOnSearch();
    }

    @Then("verify user is on hotels displayed page")
    public void verify_user_is_on_hotels_displayed_page() {

        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());
    }


    @And("select number of rooms {string},adults {string} ,child {string} and child age is {string}")
    public void selectNumberOfRoomsAdultsChildAndChildAgeIs(String room, String adult, String child, String childAge) {
        hotelPage.selectNumberOfGuestsAndNumberOfRooms(room, adult, child, childAge);
    }

    @And("user clicks on first hotel displayed on the hotel search page")
    public void user_clicks_on_first_hotel_displayed_on_the_hotel_search_page() {
        hotelPage.clickOnFirstHotel();
    }

    @And("user clicks on select room Button")
    public void user_clicks_on_select_room_button() {
        hotelPage.clickOnSelectRoomBtn();

    }

    @And("verify user is on property information page")
    public void verify_user_is_on_property_information_page() {
        Assert.assertTrue(hotelPage.propertyInfoPageIsDisplayed());

    }

    @And("user fills the guest details")
    public void user_fills_the_guest_details() {
        hotelPage.fillDetails();

    }

    @And("user clicks on proceed to payment")
    public void user_clicks_on_proceed_to_payment() {
        hotelPage.proceedToPayment();

    }

    @Then("verify user is on payment page")
    public void verify_user_is_on_payment_page() {
        Assert.assertTrue(hotelPage.paymentPageIsDisplayed());
    }

    @And("verify user is on hotels search page")
    public void verifyUserIsOnHotelsSearchPage() {
        Assert.assertTrue(hotelPage.hotelSearchPageIsDisplayed());

    }

    @And("user clicks on price low to high")
    public void userClicksOnPriceLowToHigh() {
        hotelPage.clickOnPriceLowToHigh();

    }

    @Then("verify the hotels displayed in price low to high order")
    public void verifyTheHotelsDisplayedInPriceLowToHighOrder() {
        Assert.assertTrue(hotelPage.priceIsLowToHighOrder());
    }

    @And("user clicks on price high to low")
    public void userClicksOnPriceHighToLow() {
        hotelPage.clickOnPriceHighToLow();

    }


    @Then("verify the hotels displayed in price high to low order")
    public void verifyTheHotelsDisplayedInPriceHighToLowOrder() {
        Assert.assertTrue(hotelPage.priceIsHighToLowOrder());
    }

    @And("user clicks on customer rating")
    public void userClicksOnCustomerRating() {
        hotelPage.clickOnCustomerRating();
    }

    @Then("verify the hotels displayed in descending order by customer rating")
    public void verifyTheHotelsDisplayedInDescendingOrderByCustomerRating() {
        Assert.assertTrue(hotelPage.hotelsInDescendingOrderByCustomerRating());
    }

    @And("user clicks on {string}")
    public void userClicksOn(String propType) {
        hotelPage.clickOnProperty(propType);
    }

    @Then("verify {string} are displayed in search page")
    public void verifyAreDisplayedInSearchPage(String property) {
        Assert.assertTrue(hotelPage.PropertyPageAreDisplayed(property));
    }

    @And("user enter location {string}")
    public void userEnterLocation(String city) {
        hotelPage.enterCountry(city);

    }

    @Then("verify {string} is selected with respect to the city we entered")
    public void verifyIsSelectedWithRespectToTheCityWeEntered(String radioBtn) {
        Assert.assertTrue(hotelPage.radioButtonIsSelected(radioBtn));
    }

    @Then("verify respected filters {string} are displayed in search page")
    public void verifyRespectedFiltersAreDisplayedInSearchPage(String output) {
        Assert.assertTrue(hotelPage.filterOutputIsDisplayed(output));
    }

    @Then("verify price filters {string} are displayed in search page")
    public void verifyPriceFiltersAreDisplayedInSearchPage(String priceRange) {
        Assert.assertTrue(hotelPage.priceRangeIsDisplayedCorrectly(priceRange));
    }

    @And("user select one {string}")
    public void userSelectOne(String rating) {
        hotelPage.selectRating(rating);

    }

    @Then("verify the hotels with rating grater than {string} is displayed on the search page")
    public void verifyTheHotelsWithRatingGraterThanIsDisplayedOnTheSearchPage(String rating) {
        Assert.assertTrue(hotelPage.ratingsAreDisplayed(rating));
    }

    @And("user select one star rating {string}")
    public void userSelectOneStarRating(String star) {
        hotelPage.selectStarRating(star);

    }

    @Then("verify the hotels with star rating grater than {string} is displayed on the search page")
    public void verifyTheHotelsWithStarRatingGraterThanIsDisplayedOnTheSearchPage(String star) {
        Assert.assertTrue(hotelPage.starRatingIsDisplayedCorrectly(star));
    }

    @And("user enters location {string} on update search")
    public void userEntersLocationOnUpdateSearch(String city) {
        hotelPage.enterCityOnUpdateSearch(city);

    }

    @And("user clicks on update search button")
    public void userClicksOnUpdateSearchButton() {
        hotelPage.clickOnUpdateSearchBtn();

    }


    @Then("verify the hotel search page is updated by {string}")
    public void verifyTheHotelSearchPageIsUpdatedBy(String city) {
        Assert.assertTrue(hotelPage.hotelsAreUpdated(city));
    }



}

