package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public  void dateSelection(WebElement departureDate, List<WebElement> monthYearElement,WebElement arrowClick,String dateXpath,String date){
        //select date
        departureDate.click();
        String monthYear = date.substring(date.indexOf(" ") + 1);
        String day = date.substring(0, date.indexOf(" "));

        while (!monthYear.equals(monthYearElement.get(0).getText())) {
            //click right arrow button
            arrowClick.click();
            List<WebElement> monthYearElements;

        }
        String xpathDay = String.format(dateXpath, day);
        WebElement dayElement = driver.findElement(By.xpath(xpathDay));
        dayElement.click();

    }

}
