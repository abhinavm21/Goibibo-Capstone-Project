package com.automation.steps;

import com.automation.pages.HolidayPage;
import io.cucumber.java.en.*;

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
        holidayPage.holidayPackageIsDiplayed();
    }


    @When("user selects from {string} to {string} and date {string}")
    public void userSelectsFromToAndDate(String from, String to, String date) throws InterruptedException {

        holidayPage.fromToDateSelect(from,to,date);
    }

    @And("user selects for destination package")
    public void user_selects_for_destination_package() {

    }

    @Then("verify package page is shown")
    public void verify_package_page_is_shown() {


    }

    @When("user fills guest details")
    public void user_fills_guest_details() {


    }

    @Then("verify user is on  holidays payment page")
    public void verify_user_is_on_holidays_payment_page() {


    }

}
