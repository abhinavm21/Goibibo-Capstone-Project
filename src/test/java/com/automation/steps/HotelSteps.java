package com.automation.steps;

import com.automation.pages.HotelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;

public class HotelSteps {

    HotelPage hotelPage=new HotelPage();

    @When("user select hotel booking")
    public void user_select_hotel_booking() {
        hotelPage.clickOnHotel();
    }

    @When("user select country Type")
    public void user_select_country_type() {
        hotelPage.clickOnCountryType();

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
    public void selectNumberOfRoomsAdultsChildAndChildAgeIs(String room,String adult, String child,String childAge) {
        hotelPage.selectNumberOfGuestsAndNumberOfRooms(room,adult,child,childAge);
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
}

