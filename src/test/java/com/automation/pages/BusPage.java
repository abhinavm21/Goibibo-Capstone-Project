package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


public class BusPage extends BasePage {

    @FindBy(xpath = "//span[text()='Bus']")
    WebElement busIcon;

    public void clickOnBus() {
        waitForElementToBeVisible(busIcon);
        busIcon.click();

    }

    @FindBy(xpath = "//input[@placeholder='Enter Source']")
    WebElement source;

    @FindBy(xpath = "//input[@placeholder='Enter Destination']")
    WebElement destination;

    public void searchForBus(String from, String to) {
        source.sendKeys(from);
        String selectSource = String.format("(//span[contains(text(),'%s')])[1]", from);
        driver.findElement(By.xpath(selectSource)).click();

        destination.sendKeys(to);
        String selectDestination = String.format("(//span[contains(text(),'%s')])[1]", to);
        driver.findElement(By.xpath(selectDestination)).click();
    }

    @FindBy(xpath = "//input[@placeholder='Pick a date']")
    WebElement departureDate;

    @FindBy(css = ".dcalendarstyles__MonthNamePara-sc-r2jz2t-3.gryMsr")
    List<WebElement> monthYearElement;

    @FindBy(css = ".dcalendarstyles__MonthChangeRightArrowDiv-sc-r2jz2t-16.iJqGSS")
    WebElement arrowClick;

    String dateXpath = "//span[text()='%s']";

    public void selectDate(String date) {

        dateSelection(departureDate, monthYearElement, arrowClick, dateXpath, date);

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

    @FindBy(xpath = "(//span[text()='SELECT SEAT'])[1]")
    WebElement selectSeatBtn;

    public void selectKSRTCBus() throws NoSuchElementException {
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ksrtc.isDisplayed();
            showBuses.click();
            selectSeatBtn.click();
        } catch (Exception e){
            selectSeatBtn.click();
        }finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

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
        if (ladiesSeat.isDisplayed()) {
            ladiesSeat.click();
        } else {
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

        if (!maleGender.isDisplayed()) {
            femaleGender.click();
        } else {
            maleGender.click();
        }

        email.sendKeys(ConfigReader.getConfigValue("email"));
        mobNo.sendKeys(ConfigReader.getConfigValue("phoneNumber"));
        address.sendKeys(ConfigReader.getConfigValue("BillingAddress"));
        pinCode.sendKeys(ConfigReader.getConfigValue("pinCode"));

        clickState.click();
        String selectState = String.format("//li[text()='%s']", ConfigReader.getConfigValue("state"));
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

    @FindBy(css = ".SearchWidgetstyles__SwapIconWrap-sc-1mr4hwz-9.eoDMqf")
    WebElement locationIcon;

    public void clickOnLocationChanger() {
        locationIcon.click();
    }


    public boolean locationsInterchanged(String source1, String destination1) {

        System.out.println(source.getAttribute("value") + "=" + source1);
        System.out.println(destination.getAttribute("value") + "=" + destination1);

        return source.getAttribute("value").equals(source1) && destination.getAttribute("value").equals(destination1);
    }

    @FindBy(xpath = "//label[@data-testid='autosuggestErrorText']")
    WebElement errorMsg;

    public boolean errorMsgDisplayed() {
        return errorMsg.isDisplayed();
    }

    @FindBy(xpath = "//span[@data-val='rating_high']")
    WebElement ratingDesc;

    public void clickOnRating() {
        ratingDesc.click();
    }

    @FindBy(css = ".SrpActiveCardstyles__NumbersBoldSpan-sc-yk1110-16.rjPWt")
    List<WebElement> ratingList;
    public boolean ratingsInDescendingOder() {

        List<Double> li = new ArrayList<>();

        for (WebElement rate : ratingList) {
            li.add(Double.valueOf(rate.getText().trim()));
        }
        System.out.println("Original list (high to low) \n" + li);

        List<Double> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        Collections.reverse(copy_li);
        System.out.println("reverse sorter list (high to low)\n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='rating_low']")
    WebElement ratingAsc;

    public void clickOnRatingAscending() {
         ratingAsc.click();
    }

    public boolean ratingsInAscendingOder() {
        List<Double> li = new ArrayList<>();

        for (WebElement rate : ratingList) {
            li.add(Double.valueOf(rate.getText().trim()));
        }
        System.out.println("Original list (high to low) \n" + li);

        List<Double> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }


}
