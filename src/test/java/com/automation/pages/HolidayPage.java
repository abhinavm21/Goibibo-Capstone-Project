package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HolidayPage extends BasePage {

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

    public void holidayBooking() {
        holidayClick.click();
    }

    public boolean verifyHolidayPageIsDisplayed() {
        return saleHeading.isDisplayed();
    }

    public void honeymoonSelect() {
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

    @FindBy(xpath = "(//*[@class='variant-card-heading'])[1]")
    WebElement withFlightClick;

    @FindBy(xpath = "//*[@class='skipBtn']")
    WebElement skipBtn;

    @FindBy(className = "clearAll")
    WebElement clearAllClick;

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

    public void selectDestination(String dest) {
        List<WebElement> destinationPlaces = driver.findElements(By.className("packageHead"));
        int y = 100;
        boolean flag = true;
        while (flag) {
            js.executeScript("window.scrollBy(0," + y + ")");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (WebElement ele : destinationPlaces) {
                if (ele.getText().contains(dest)) {
                    flag = false;
                    jsClick(ele);
                    break;
                }
            }
            destinationPlaces = driver.findElements(By.className("packageHead"));
            y += 200;

        }
        if (isPresent(withFlightClick)) {
            withFlightClick.click();
        }
        String originalWindow = driver.getWindowHandle();
        Set<String> listOfWindow = driver.getWindowHandles();

        for (String window : listOfWindow) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
            }
        }

    }

    @FindBy(id = "fromCity")
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

    public void fromToDateSelect(String from, String date) {



        //select from
        fromClick.click();
        fromInput.clear();
        fromInput.sendKeys(from);
        String loc = String.format(clickOnFirstSource, from);
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

    public boolean verifyPackagePageIsDisplayed(String dest) {

        if (isPresent(skipBtn)) {
            skipBtn.click();
        }

        waitForElementToBeVisible(titleHeading);
        return titleHeading.getText().contains(dest);
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

    @FindBy(xpath = "//div/p[text()='Add Traveller']")
    WebElement travellerSelect;

    @FindBy(name = "FIRST_NAME")
    WebElement firstName;

    @FindBy(name = "LAST_NAME")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"_DD\"]/div/div[1]")
    WebElement dateDOB;

    @FindBy(xpath = "//*[@id=\"_MM\"]/div/div[1]/div")
    WebElement monthDOB;

    @FindBy(xpath = "//*[@id=\"_YYYY\"]/div/div[1]/div")
    WebElement yearDOB;

    @FindBy(xpath = "//div[2]/div/div[4]/div/div[2]/div/div[1]")
    WebElement gender;

    @FindBy(xpath = "//div[5]/div/div[2]/div/div[1]")
    WebElement nationality;

    @FindBy(name = "PASSPORT_NUMBER")
    WebElement passportNumber;

    @FindBy(xpath = "//div[contains(text(),'DD')]")
    WebElement passportExpiryDay;

    @FindBy(xpath = "//div[contains(text(),'MM')]")
    WebElement passportExpiryMonth;

    @FindBy(id = "_YYYY")
    WebElement passportExpiryYear;

    @FindBy(xpath = "//div[8]/div/div[2]/div/div[1]")
    WebElement passportIssueCountry;

    @FindBy(xpath = "//div[4]/button")
    WebElement addTravellerBtn;

    String adultCount = "//*[@id='modalpopup']/div/div/div[2]/div/div/div/div/div[%s]";

    @FindBy(name = "EMAIL")
    WebElement email;

    @FindBy(name = "MOBILE_NUMBER")
    WebElement mobNumber;

    @FindBy(id = "react-select-2-input")
    WebElement mobCode;

    @FindBy(id = "react-select-3-input")
    WebElement gstState;

    @FindBy(xpath = "//span[@data-testid='proceed-to-payment-btn']")
    WebElement paymentBtn;


    //Optimization needed
    public void fillingUsersData(String local) {
        travellerSelect.click();
        for (int i = 1; i <= Integer.parseInt(ConfigReader.getConfigValue("num")); i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//                        String xpathAdult=String.format(adultCount,i);
//                        WebElement hi = driver.findElement(By.xpath(xpathAdult));
//                        waitForElementToBeSelected(hi);
            firstName.sendKeys(ConfigReader.getConfigValue("firstName" + i));
            lastName.sendKeys(ConfigReader.getConfigValue("lastName" + i));
            dateDOB.click();

            //DayDOB
            Actions date = new Actions(driver);
            date.moveToElement(dateDOB).pause(1000)
                    .sendKeys("21").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                    .build().perform();

            //MonthDOB
            Actions month = new Actions(driver);
            month.moveToElement(monthDOB).pause(1000)
                    .sendKeys("8").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                    .build().perform();

            //YearDOB
            Actions year = new Actions(driver);
            year.moveToElement(yearDOB).pause(1000)
                    .sendKeys("1995").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                    .build().perform();

            gender.click();
            Actions maleGender = new Actions(driver);
            year.moveToElement(gender).pause(1000).sendKeys(ConfigReader.getConfigValue("Gender" + i))
                    .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                    .build().perform();
            if(Objects.equals(local, "no")) {
                nationality.click();
                Actions nationalityIndia = new Actions(driver);
                year.moveToElement(nationality).pause(1000).sendKeys("Ind")
                        .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                        .build().perform();

                passportNumber.sendKeys(ConfigReader.getConfigValue("passportNumber" + i));


                //DayPassportExpire
                passportExpiryDay.click();
                Actions passDate = new Actions(driver);
                passDate.moveToElement(passportExpiryDay).pause(1000)
                        .sendKeys("21").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                        .build().perform();

                //MonthPassportExpire
                Actions passMonth = new Actions(driver);
                passMonth.moveToElement(passportExpiryMonth).pause(1000)
                        .sendKeys("10").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                        .build().perform();

                //YearPassportExpire
                Actions passYear = new Actions(driver);
                passYear.moveToElement(passportExpiryYear).pause(1000)
                        .sendKeys("2035").pause(1000).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.ARROW_DOWN)
                        .build().perform();

                passportIssueCountry.click();
                Actions passIssueCty = new Actions(driver);
                passIssueCty.moveToElement(passportIssueCountry).pause(1000).sendKeys("Ind")
                        .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                        .build().perform();
            }
            addTravellerBtn.click();
        }

        email.sendKeys(ConfigReader.getConfigValue("EMAIL"));

        mobCode.click();
        Actions phoneCode = new Actions(driver);
        phoneCode.moveToElement(mobCode).pause(1000).sendKeys("Ind")
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                .build().perform();

        mobNumber.sendKeys(ConfigReader.getConfigValue("MOB_NUMBER"));

        gstState.click();
        Actions state = new Actions(driver);
        state.moveToElement(mobCode).pause(1000).sendKeys("Kera")
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                .build().perform();

        paymentBtn.click();
    }

    public boolean verifyPaymentPageIsDisplayed() {
        WebElement fareSummary = null;
        boolean found = false;

        while (!found) {
            try {
                // Try to find the element
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                fareSummary = driver.findElement(By.xpath("//span[text()='Fare Summary']"));
                found = true;
            } catch (StaleElementReferenceException e) {
                // Handle the stale element exception
                System.out.println("Element is stale, retrying...");
                // Optionally, wait for a few seconds before retrying
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return found;
    }
}

