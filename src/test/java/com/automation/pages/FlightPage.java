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

    public void selectDepartureDate(String date1){

        //select date
        departureDate.click();
        String monthYear = date1.substring(date1.indexOf(" ") + 1);
        String day = date1.substring(0, date1.indexOf(" "));


        while (!monthYear.equals(monthYearElement.get(0).getText())) {

            //click right arrow button
            WebElement click = driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]"));
            click.click();

            List<WebElement> monthYearElements;


        }
        String xpathDay = String.format("//p[@class=\"fsw__date\" and contains(text(),'%s')]", day);
        WebElement dayElement = driver.findElement(By.xpath(xpathDay));
        dayElement.click();

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
}
