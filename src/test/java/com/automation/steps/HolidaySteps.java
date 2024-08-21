package com.automation.steps;

import com.automation.pages.HolidayPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HolidaySteps {
    HolidayPage holidayPage = new HolidayPage();

    @When("select holiday booking")
    public void select_holiday_booking() {
        holidayPage.holidayBooking();
    }

    @Then("verify user is on holiday search page")
    public void verify_user_is_on_holiday_search_page() {
        holidayPage.verifyHolidayPageIsDisplayed();
    }

    @When("user select handcrafted honeymoon holiday type")
    public void user_select_handcrafted_honeymoon_holiday_type() {
        holidayPage.honeymoonSelect();
    }

    @Then("verify user is on holiday packages page")
    public void verify_user_is_on_holiday_packages_page() {
        Assert.assertTrue(holidayPage.holidayPackageIsDisplayed());
    }



    @When("user selects for destination package")
    public void user_selects_for_destination_package() {
        holidayPage.selectDestination();
    }

    @Then("verify package page is shown")
    public void verify_package_page_is_shown() {
        Assert.assertTrue(holidayPage.verifyPackagePageIsDisplayed());
    }

    @When("user selects from {string} and date {string}")
    public void userSelectsFromToAndDate(String from, String date) {
        holidayPage.fromToDateSelect(from,date);
    }

    @And("user clicks the proceed to payment button")
    public void userClicksTheProceedToPaymentButton() {
        holidayPage.proceedToPaymentClick();
    }

    @Then("verify user is on data filling page")
    public void verifyUserIsOnDataFillingPage() {
        Assert.assertTrue(holidayPage.verifyDataFillingPageIsDisplayed());
    }

    @When("user fills guest details")
    public void user_fills_guest_details() {

    }

    @Then("verify user is on holidays payment page")
    public void verify_user_is_on_holidays_payment_page() {


    }

}
