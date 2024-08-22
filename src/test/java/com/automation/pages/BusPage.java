package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BusPage extends BasePage{

    @FindBy(xpath = "//span[text()='Bus']")
    WebElement busIcon;

    public void clickOnBus() {
        waitForElementToBeVisible(busIcon);
        busIcon.click();

    }
    @FindBy(id = "autosuggestBusSRPSrcHome")
    WebElement source;

    @FindBy(id = "autosuggestBusSRPDestHome")
    WebElement destination;

    public void searchForBus(String from, String to) {
        source.sendKeys(from);
        String selectSource=String.format("(//span[contains(text(),'%s')])[1]",from);
        driver.findElement(By.xpath(selectSource)).click();

        destination.sendKeys(to);
        String selectDestination=String.format("(//span[contains(text(),'%s')])[1]",to);
        driver.findElement(By.xpath(selectDestination)).click();
    }

    @FindBy(xpath = "//input[@placeholder='Pick a date']")
    WebElement departureDate;

    @FindBy(css = ".dcalendarstyles__MonthNamePara-sc-r2jz2t-3.gryMsr")
    List<WebElement> monthYearElement;

    @FindBy(css = ".dcalendarstyles__MonthChangeRightArrowDiv-sc-r2jz2t-16.iJqGSS")
    WebElement arrowClick;

    String dateXpath="//span[text()='%s']";

    public void selectDate(String date) {

        dateSelection(departureDate,monthYearElement,arrowClick,dateXpath,date);

    }

    @FindBy(xpath = "//button[@data-testid='searchBusBtn']")
    WebElement searchBtn;
    public void clickOnSearch() {

        searchBtn.click();
    }

    @FindBy(xpath = "(//span[text()='SELECT SEAT'])[1]")
    WebElement selectSeat;

    @FindBy(xpath = "//span[text()='UPDATE SEARCH']")
    WebElement updateSearch;

    public boolean busSearchPageIsDisplayed() {
        return selectSeat.isDisplayed() && updateSearch.isDisplayed();
    }

    @FindBy(xpath = "//p[contains(text(),'KSRTC')]")
    WebElement ksrtc;

    @FindBy(xpath = "//span[text()='SHOW BUSES']")
    WebElement showBuses;

    public void selectKSRTCBus() {
        if(ksrtc.isDisplayed()){
            showBuses.click();
        }

    }

    @FindBy(xpath = "(//span[text()='SELECT SEAT'])[1]")
    WebElement selectSeatBtn;
    public void clickOnSelectSeat() {

        selectSeatBtn.click();
    }

    @FindBy(xpath = "//button[text()='SELECT SEATS TO PROCEED']")
    WebElement proceedWithSelectedSeat;

    public boolean seatsAreDisplayed() {

        return proceedWithSelectedSeat.isDisplayed();
    }

    @FindBy(xpath = "(//*[contains(@class,'bgRWOR')])[1]")
    WebElement ladiesSeat;

    @FindBy(xpath = "(//*[contains(@class,'jenkXX')])[1] ")
    WebElement otherSeats;

    public void selectSeat() {
        if(ladiesSeat.isDisplayed()){
            ladiesSeat.click();
        }else {
            otherSeats.click();
        }
    }

    @FindBy(xpath = "//button[text()='CONTINUE']")
    WebElement continueBtn;

    public void clickOnContinue() {

        continueBtn.click();
    }

    @FindBy(xpath = "//header[text()='Review your Booking']")
    WebElement reviewBooking;
    public boolean reviewOfBookingTextIsDisplayed() {
        waitForElementToBeVisible(reviewBooking);
        return reviewBooking.isDisplayed();
    }

    @FindBy(xpath = "//input[@placeholder='Enter Full Name']")
    WebElement fName;

    @FindBy(xpath = "//input[@placeholder='Age']")
    WebElement age;

    @FindBy(css = ".genderTabsList.selected']")
    WebElement femaleGender;

    @FindBy(className = "genderTabsList")
    WebElement maleGender;

    @FindBy(xpath = "//input[@placeholder='Enter Email Address']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    WebElement mobNo;

    @FindBy(id = "Billing Address")
    WebElement address;

    @FindBy(id = "Pincode")
    WebElement pinCode;

    @FindBy(css = ".sc-kQsIoO.itfWUh")
    WebElement clickState;

    @FindBy(css = ".sc-ePZHVD.idfhTT")
    WebElement confirmCheckBox;

    public void fillsDetailsOfBusTraveller() {

        fName.sendKeys(ConfigReader.getConfigValue("fname"));
        age.sendKeys(ConfigReader.getConfigValue("age"));

        if (!maleGender.isDisplayed()){
            femaleGender.click();
        }else {
            maleGender.click();
        }

        email.sendKeys(ConfigReader.getConfigValue("email"));
        mobNo.sendKeys(ConfigReader.getConfigValue("phoneNumber"));
        address.sendKeys(ConfigReader.getConfigValue("BillingAddress"));
        pinCode.sendKeys(ConfigReader.getConfigValue("pinCode"));

        clickState.click();
        String selectState=String.format("//li[text()='%s']", ConfigReader.getConfigValue("state"));
       driver.findElement(By.xpath(selectState)).click();
       confirmCheckBox.click();

    }

    @FindBy(xpath = "//button[contains(text(),'Pay')]")
    WebElement payButton;

    public void clickOnPayButton() {
        waitForElementToBeVisible(payButton);
        payButton.click();
    }

    @FindBy(xpath = "//span[text()='UPI Options']")
    WebElement UPIOptions;

    @FindBy(xpath = "//span[text()='Credit/Debit/ATM Card']")
    WebElement creditAndDebit;

    public boolean paymentPageDisplayed() {
        return UPIOptions.isDisplayed() && creditAndDebit.isDisplayed();
    }

    public void clickOnUPIOptions() {
           UPIOptions.click();
    }

    @FindBy(xpath = "//button[text()='Send payment request']")
    WebElement paymentRequestBtn;

    @FindBy(xpath = "//button[text()='Generate new QR']")
    WebElement qrOption;

    public boolean paymentRequestAndQROptionIsDisplayed() {
        return paymentRequestBtn.isDisplayed() && qrOption.isDisplayed();
    }
}
