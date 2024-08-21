package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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


        @FindBy(xpath = "//h1[text()='Holiday Packages']")
        WebElement holidayPackage;

        String destinationXpath = "//*[contains(@title,'%s')]";

        @FindBy(xpath = "(//*[@class='variant-card-heading'])[1]" )
        WebElement withFlightClick;

        @FindBy(xpath = "//*[@class='skipBtn']")
        WebElement skipBtn;

        public boolean holidayPackageIsDisplayed() {
                String originalWindow = driver.getWindowHandle();
                Set<String> listOfWindow = driver.getWindowHandles();

                for (String window : listOfWindow) {
                        if (!window.equals(originalWindow)) {
                                driver.switchTo().window(window);
                        }
                }

                return holidayPackage.isDisplayed();
        }

        public void selectDestination() {
                String loc = String.format(destinationXpath,ConfigReader.getConfigValue("DestinationPackageName"));
                driver.findElement(By.xpath(loc)).click();

               if(isPresent(withFlightClick)){
                      withFlightClick.click();
               }
        }

        @FindBy(id="fromCity")
        WebElement fromClick;

        @FindBy(className = "citypicker_input")
        WebElement fromInput;

        @FindBy(xpath = "//*[text()='ROOMS & GUESTS']")
        WebElement toClick;

        @FindBy(id = "date")
        WebElement dateInput;

        @FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
        WebElement monthYearElement;

        @FindBy(xpath = "//div/button")
        WebElement searchBtn;

        String clickOnFirstSource = "//b[contains(text(),'%s')]";

        public void fromToDateSelect(String from, String date)  {


                if(isPresent(skipBtn)){
                        skipBtn.click();
                }

                //select from
                fromClick.click();
                fromInput.clear();
                fromInput.sendKeys(from);
                String loc = String.format(clickOnFirstSource,from);
                driver.findElement(By.xpath(loc)).click();

                //select date
                //dateInput.click();
                String monthYear = date.substring(date.indexOf(" ") + 1);
                String day = date.substring(0, date.indexOf(" "));


                while (!monthYear.equals(monthYearElement.getText())) {

                        //click right arrow button
                        WebElement click = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
                        click.click();

                }
                String xpathDay = String.format("//*[@class='dateInnerPara' and contains(text(),'%s')]", day);
                WebElement dayElement = driver.findElement(By.xpath(xpathDay));
                dayElement.click();

                //select outside to
                Actions action = new Actions(driver);
                action.moveToElement(toClick).pause(1000)
                        .click(toClick)
                        .build().perform();

                //search
                searchBtn.click();
        }

        @FindBy(className = "topHeading")
        WebElement titleHeading;

        public boolean verifyPackagePageIsDisplayed() {
                String originalWindow = driver.getWindowHandle();
                Set<String> listOfWindow = driver.getWindowHandles();

                for (String window : listOfWindow) {
                        if (!window.equals(originalWindow)) {
                                driver.switchTo().window(window);
                        }
                }
               return titleHeading.getText().contains(ConfigReader.getConfigValue("DestinationPackageName"));
        }

        @FindBy(xpath = "//*[@id=\"continue\"]/span")
        WebElement proceedToPaymentBtn;

        public void proceedToPaymentClick() {
                proceedToPaymentBtn.click();
        }

        @FindBy(xpath = "(//div[1]/h4)[1]")
        WebElement travellersText;

        public boolean verifyDataFillingPageIsDisplayed() {
                return travellersText.isDisplayed();
        }
}
