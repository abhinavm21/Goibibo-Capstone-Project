package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class HolidayPage extends BasePage{

        @FindBy(xpath = "//li[6]/a/span[2]")
        WebElement holidayClick;

        @FindBy(xpath = "//div/h2")
        WebElement saleHeading;

        @FindBy(xpath = "/html/body/div[1]/div/div[4]/div/div/div/ul/li[3]/span[2]")
        WebElement superDealsClick;

        @FindBy(xpath = "//li[contains(text(),\"Honeymoon\")]")
        WebElement honeymoonClick;

        @FindBy(xpath = "//ul[1]/li[3]/a")
        WebElement adventBeginningsClick;

        public void holidayBooking()  {
                holidayClick.click();
        }

        public void verifyHolidayPageIsDisplayed()  {
                saleHeading.isDisplayed();
        }

        public void honeymoonSelect(){
                String originalWindow = driver.getWindowHandle();
                Set<String> listOfWindow = driver.getWindowHandles();

                for (String window : listOfWindow) {
                        if (!window.equals(originalWindow)) {
                                driver.switchTo().window(window);
                        }
                }

                superDealsClick.click();
                honeymoonClick.click();
                adventBeginningsClick.click();
        }


        public void holidayPackageIsDiplayed() {
        }

        @FindBy(id="fromCity")
        WebElement fromInput;

        @FindBy(id = "dest")
        WebElement toInput;

        @FindBy(id = "date")
        WebElement dateInput;

        @FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
        WebElement monthYearElement;


        public void fromToDateSelect(String from, String to, String date) throws InterruptedException {

                String originalWindow = driver.getWindowHandle();
                Set<String> listOfWindow = driver.getWindowHandles();

                for (String window : listOfWindow) {
                        if (!window.equals(originalWindow)) {
                                driver.switchTo().window(window);
                        }
                }


                //select from
                fromInput.click();
                fromInput.sendKeys(from);
                

                //select to

                toInput.click();
                toInput.sendKeys(to);

                //select date
                dateInput.click();
                String monthYear = date.substring(date.indexOf(" ") + 1);
                String day = date.substring(0, date.indexOf(" "));


                while (!monthYear.equals(monthYearElement.getText())) {

                        //click right arrow button
                        WebElement click = driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]"));
                        click.click();

                }
                String xpathDay = String.format("//div[contains(text(),'%s')]", day);
                WebElement dayElement = driver.findElement(By.xpath(xpathDay));
                dayElement.click();
        }
}
