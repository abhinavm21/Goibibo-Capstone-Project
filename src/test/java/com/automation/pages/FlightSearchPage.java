package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage extends BasePage{

    @FindBy(xpath = "//button[text()='VIEW FARES']")
    WebElement viewFareBtn;

    @FindBy(xpath = "//button[text()='UPDATE SEARCH']")
    WebElement updateSearchBtn;


    public boolean flightSearchPageIsDisplayed() {
        waitForElementToBeVisible(updateSearchBtn);
        return updateSearchBtn.isDisplayed();
    }
}
