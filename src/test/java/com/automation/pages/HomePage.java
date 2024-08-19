package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='sc-fXSgeo fclkTx']")
    WebElement popUp1;

    @FindBy(xpath = "//span[@class='logSprite icClose']")
    WebElement popUp2;

    @FindBy(xpath = "//p[@class='sc-jlwm9r-1 ewETUe']")
    WebElement popUp3;


    public void openWebsite() throws InterruptedException {
        driver.get("https://www.goibibo.com/");
        Thread.sleep(1000);

        if(popUp1.isDisplayed()){
            popUp1.click();
        }else {
            popUp2.click();
        }
        if(popUp3.isDisplayed()){
            popUp3.click();
        }
    }
}
