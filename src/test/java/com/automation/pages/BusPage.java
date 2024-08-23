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

    @FindBy(css = ".BusSleeperIcon-sc-ha5qpg-0.cdzSbl")
    WebElement outerStateSleeper;

    public void selectSeat() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ladiesSeat.isDisplayed();
            ladiesSeat.click();
        } catch(Exception e){
            try {
                otherSeats.click();
            }catch (Exception h){
                outerStateSleeper.click();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[text()='CONTINUE']")
    WebElement continueBtn;

    public boolean continueBtnIsDisplayed() {
        return continueBtn.isDisplayed();
    }

    @FindBy(xpath = "//div/section[1]/div/div[2]/div[1]/div/label[1]")
    WebElement boardingPoint;

    @FindBy(xpath = "//div/section[1]/div/div[2]/div[2]/div/label[1]")
    WebElement droppingPoint;

    public void clickOnContinue() {
        try {
            outerStateSleeper.isDisplayed();
            boardingPoint.click();
            droppingPoint.click();
            waitForElementToBeVisible(continueBtn);
            continueBtn.click();
        } catch (Exception e) {
            waitForElementToBeVisible(continueBtn);
            continueBtn.click();
        }
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

    @FindBy(xpath = "//li[contains(@class,'genderTab')]//span[text()='Female']")
    WebElement femaleGender;

    @FindBy(xpath = "//li[contains(@class,'genderTab')]//span[text()='Male']")
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


            if (ConfigReader.getConfigValue("gender").equals("female")) {
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

    @FindBy(xpath = "(//span[@class='checkmark'])[1]")
    WebElement secureTrip;

    public void clickOnPayButton() {
        try {
            secureTrip.isDisplayed();
            secureTrip.click();
            payButton.click();
        }catch (Exception e){
            payButton.click();
        }

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

    @FindBy(xpath = "//span[@data-val='late_departure']")
    WebElement departureAsc;
    public void clickOnDepartureAsc() {
        departureAsc.click();
    }

    @FindBy(xpath = "//div[@class='SrpActiveCardstyles__DepartureWrapperDiv-sc-yk1110-21 cOOMQi']/p[@class='SrpActiveCardstyles__BusBoldtxtPara-sc-yk1110-7 faoGPx']")
    List<WebElement> departureList;

    public boolean departureInAscendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : departureList) {
            String[] string = dep.getText().split(":");
            li.add(Integer.parseInt(string[0]));
        }
        System.out.println("Original list (low to high) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(low to high) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='early_departure']")
    WebElement departureDesc;
    public void clickOnDepartureDesc() {
        departureDesc.click();
    }

    public boolean departureInDescendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : departureList) {
            String[] string = dep.getText().split(":");
            li.add(Integer.parseInt(string[0]));
        }
        System.out.println("Original list (high to low) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        Collections.reverse(copy_li);
        System.out.println("reverse sorted list (high to low)\n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='late_arrival']")
    WebElement arrivalAsc;

    public void clickOnArrivalAsc() {
        arrivalAsc.click();
    }

    @FindBy(xpath = "//div[contains(@class,'ArrivalWrapper')]/p[@class='SrpActiveCardstyles__BusBoldtxtPara-sc-yk1110-7 faoGPx']")
    List<WebElement> arrivalList;

    public boolean arrivalInAscendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : arrivalList) {
            String[] string = dep.getText().split(":");
            li.add(Integer.parseInt(string[0]));
        }
        System.out.println("Original list (low to high) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(low to high) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='early_arrival']")
    WebElement arrivalDesc;

    public void clickOnArrivalDesc() {
        arrivalDesc.click();
    }

    public boolean arrivalInDescendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : arrivalList) {
            String[] string = dep.getText().split(":");
            li.add(Integer.parseInt(string[0]));
        }
        System.out.println("Original list (high to low) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        Collections.reverse(copy_li);
        System.out.println("reverse sorted list (high to low)\n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='high_price']")
    WebElement priceAsc;

    public void clickOnCheapestAsc() {
        priceAsc.click();
    }

    @FindBy(css = ".SrpActiveCardstyles__RupeetxtSpan-sc-yk1110-37.iIIlCN")
    List<WebElement> priceList;


    public boolean priceInAscendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : priceList) {
            li.add(Integer.parseInt(dep.getText().trim()));
        }
        System.out.println("Original list (low to high) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(low to high) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        return li.equals(copy_li);
    }

    @FindBy(xpath = "//span[@data-val='low_price']")
    WebElement priceDesc;

    public void clickOnCheapestDesc() {
        priceDesc.click();
    }

    public boolean priceInDescendingOrder() {
        List<Integer> li = new ArrayList<>();

        for (WebElement dep : priceList) {
            li.add(Integer.parseInt(dep.getText().trim()));
        }
        System.out.println("Original list (high to low) \n" + li);

        List<Integer> copy_li = new ArrayList<>(li);
        System.out.println("Copy of original list(high to low) \n " + copy_li);

        Collections.sort(copy_li);
        System.out.println("Sorted list (low to high) \n" + copy_li);

        Collections.reverse(copy_li);
        System.out.println("reverse sorted list (high to low)\n" + copy_li);

        return li.equals(copy_li);
    }


}
