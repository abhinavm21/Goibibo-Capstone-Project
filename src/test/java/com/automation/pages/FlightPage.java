package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightPage extends BasePage {

    @FindBy(xpath = "(//p[text()='Enter city or airport'])[1]")
    WebElement from;

    @FindBy(xpath = "//input[@type='text']")
    WebElement enterFrom;

    String clickOnFirstSource="(//ul[@id='autoSuggest-list']//li[@role='presentation']//span[contains(text(),'%s')])[1]";

    @FindBy(xpath = "//input[@type='text']")
    WebElement enterTo;


    @FindBy(xpath = "//span[text()='SEARCH FLIGHTS']")
    WebElement search;


    public void searchForFlight(String from1,String to1) throws InterruptedException {
        Thread.sleep(3000);

        //enter source
        from.click();
        enterFrom.sendKeys(from1);
        String loc = String.format(clickOnFirstSource, from1);
        driver.findElement(By.xpath(loc)).click();

        //enter destination
        enterTo.sendKeys(to1);
        String loc1 = String.format(clickOnFirstSource, to1);
        driver.findElement(By.xpath(loc1)).click();

    }


    @FindBy(xpath = "(//p[@class='sc-12foipm-4 czGBLf fswWidgetTitle'])[3]")
    WebElement departureDate;

    @FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
    List<WebElement> monthYearElement;

    @FindBy(xpath = "//span[@aria-label=\"Next Month\"]")
    WebElement arrowClick;

    String dateXpath="//p[@class=\"fsw__date\" and contains(text(),'%s')]";

    public void selectDepartureDate(String date1){

        dateSelection(departureDate,monthYearElement,arrowClick,dateXpath,date1);

    }

    public void clickOnSearchBtn(){
        //click on search
        search.click();

    }


    @FindBy(xpath ="//div[text()='source and destination cannot be same']")
    WebElement errorMsg;
    public String errorMessageIsDisplayed() {
        return errorMsg.getText();
    }


    @FindBy(xpath = "//button[text()='VIEW FARES']")
    WebElement viewFareButton;
    public boolean viewFareIsDisplayed() {
        return viewFareButton.isDisplayed();
    }
}
