package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class HotelPage extends BasePage{


        @FindBy(xpath = "//span[text()='Hotels']")
        WebElement hotel;

        @FindBy(xpath = "(//input[@name='CountryType'])[1]")
        WebElement radioButton;

        @FindBy(xpath = "//input[@placeholder='e.g. - Area, Landmark or Property Name']")
        WebElement place;

        public void clickOnHotel() {
                hotel.click();

        }

        public void clickOnCountryType() {

                radioButton.click();
        }

        String clickOnFirstLoc="//div[@class='dwebCommonstyles__FlexItem-sc-112ty3f-4 ecJXVL']//div[contains(text(),'%s')]";

        public void enterLocation(String loc) {

                place.sendKeys(loc);
                String loc1 = String.format(clickOnFirstLoc, loc);
                driver.findElement(By.xpath(loc1)).click();
//                selectPlace.click();
        }

        @FindBy(xpath = "//div[@data-testid='openCheckinCalendar']")
        WebElement checkInDate;
        @FindBy(xpath = "//div[@data-testid='openCheckoutCalendar']")
        WebElement checkOutDate;

        @FindBy(xpath = "//span[@data-testid='currentCalendarMonthName']")
        List<WebElement> monthYearElements;


        public void selectCheckInDate(String date) {
                checkInDate.click();
                String monthYear = date.substring(date.indexOf(" ") + 1);
                String day = date.substring(0, date.indexOf(" "));


                while (!monthYear.equals(monthYearElements.get(0).getText())) {
                        //click right arrow button
                        WebElement click = driver.findElement(By.xpath("//span[@data-testid='calendarRightArrowBtn']"));
                        click.click();

                        List<WebElement> monthYearElements;

                }
                String xpathDay = String.format("//li[@class='date_is_selectable_true']//span[text()='%s']", day);
                WebElement dayElement = driver.findElement(By.xpath(xpathDay));
                dayElement.click();



        }

        @FindBy(xpath = "//span[@data-testid='currentCalendarMonthName']")
        List<WebElement> monthYearElement;
        public void selectCheckOutDate(String date) {

                checkOutDate.click();
                String monthYear = date.substring(date.indexOf(" ") + 1);
                String day = date.substring(0, date.indexOf(" "));


                while (!monthYear.equals(monthYearElement.get(0).getText())) {

                        //click right arrow button
                        WebElement click = driver.findElement(By.xpath("//span[@data-testid='calendarRightArrowBtn']"));
                        click.click();

                        List<WebElement> monthYearElements;


                }
                String xpathDay = String.format("//li[@class='date_is_selectable_true']//span[text()='%s']", day);
                WebElement dayElement = driver.findElement(By.xpath(xpathDay));
                dayElement.click();

        }

        @FindBy(xpath = "//button[text()='Search']")
        WebElement search;
        public void clickOnSearch() {

                search.click();
        }

        @FindBy(xpath = "//span[text()='Hotel' and @class='HotelCardstyles__HotelTypeTag-sc-1s80tyk-17 gyCpqt']")
        WebElement hotelDisplayed;

        public boolean hotelPageIsDisplayed() {
                waitForElementToBeVisible(hotelDisplayed);
                return hotelDisplayed.isDisplayed();
        }

        @FindBy(xpath = "//input[@type='text']")
        WebElement guestAndNumber;

        @FindBy(xpath = "//span[@data-testid='button-room-add']")
        WebElement addRooms;

        @FindBy(xpath = "//span[@data-testid='button-adult-add']")
        WebElement addAdults;

        @FindBy(xpath = "//span[@data-testid='button-child-add']")
        WebElement addChild;

        @FindBy(xpath = "//h4[@data-testid='room-count']")
        WebElement roomCount;

        @FindBy(xpath = "//h4[@data-testid='adult-count']")
        WebElement adultCount;

        @FindBy(xpath = "//h4[@data-testid='child-count']")
        WebElement childCount;

        @FindBy(xpath = "//button[text()='Done']")
        WebElement doneBtn;

        @FindBy(xpath = "//h4[text()='Select']")
        WebElement clickOnChildAge;



        public void selectNumberOfGuestsAndNumberOfRooms(String room,String adult,String child,String childAge) {
                guestAndNumber.click();

                int room1=Integer.parseInt(room);
                int adult1=Integer.parseInt(adult);
                int child1=Integer.parseInt(child);

                int roomCount1=Integer.parseInt(roomCount.getText());
                int adultCount1=Integer.parseInt(adultCount.getText());
                int childCount1=Integer.parseInt(childCount.getText());

                if(roomCount1==room1){
                        System.out.println();
                }else {
                        while (roomCount1!=room1){
                                addRooms.click();
                                roomCount1++;
                        }
                }

                if(adultCount1==adult1){
                        System.out.println();
                }else {
                        while (adultCount1!=adult1){
                                addAdults.click();
                                adultCount1++;
                        }
                }

                if(childCount1==child1){
                        System.out.println();
                }else {
                        while (childCount1!=child1){
                                addChild.click();
                                childCount1++;
                        }
                }
                clickOnChildAge.click();
                String s = "//li[text()='%s']";
                if(child1>0){
                        String loc = String.format(s, childAge);
                        driver.findElement(By.xpath(loc)).click();

                }
              doneBtn.click();
        }

        @FindBy(xpath = "(//div[@class='HotelCardstyles__WrapperSectionMetaDiv-sc-1s80tyk-5 bxXAbx'])[1]")
        WebElement clickOnFirstHotel;

        //Book hotel
        public void clickOnFirstHotel(){
                waitForElementToBeVisible(clickOnFirstHotel);
                clickOnFirstHotel.click();

        }
        @FindBy(xpath = "(//button[@data-testid='selectRoomBtn'])[1]")
        WebElement selectRoomBtn;

        public void clickOnSelectRoomBtn(){
                String originalWindow = driver.getWindowHandle();
                Set<String> listOfWindow = driver.getWindowHandles();

                for (String window : listOfWindow) {
                        if (!window.equals(originalWindow)) {
                                driver.switchTo().window(window);
                        }
                }
                selectRoomBtn.click();
        }

        @FindBy(xpath = "//h3[text()='PROPERTY INFO']")
        WebElement propertyInfo;

        public boolean propertyInfoPageIsDisplayed(){
                return propertyInfo.isDisplayed() && proceedToPayment.isDisplayed();
        }

        @FindBy(xpath = "//select[@class='PersonalProfilestyles__NameEnterSelect-sc-1t6fe6a-6 igUikR']")
        WebElement selectTitle;

        @FindBy(xpath = "//input[@placeholder='Enter First Name']")
        WebElement fName;

        @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
        WebElement lName;

        @FindBy(xpath = "//input[@placeholder='Enter Email Address']")
        WebElement email;

        @FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
        WebElement phoneNumber;

        @FindBy(xpath = "//input[@id='Billing Address']")
        WebElement billingAddress;

        @FindBy(xpath = "//input[@id='Pincode']")
        WebElement pinCode;

        @FindBy(xpath = "//div[@class='sc-fxMiRr cTmFXt']")
        WebElement state;

        @FindBy(xpath = "//li[@class='sc-dxIsLa ehHrVE' and text()='Kerala']")
        WebElement selectState;

        @FindBy(xpath = "//span[@class='sc-dDtQgT ezsIsE']")
        WebElement checkBox;

        public void fillDetails(){
                Select select = new Select(selectTitle);
                select.selectByVisibleText(ConfigReader.getConfigValue("title"));
                fName.sendKeys(ConfigReader.getConfigValue("fname"));
                lName.sendKeys(ConfigReader.getConfigValue("lname"));
                email.sendKeys(ConfigReader.getConfigValue("email"));
                phoneNumber.sendKeys(ConfigReader.getConfigValue("phoneNumber"));
                billingAddress.sendKeys(ConfigReader.getConfigValue("BillingAddress"));
                pinCode.sendKeys(ConfigReader.getConfigValue("pinCode"));
                state.click();
                selectState.click();
                checkBox.click();


        }
        @FindBy(xpath = "//span[text()='Proceed To Payment Options']")
        WebElement proceedToPayment;

        public void proceedToPayment(){
            proceedToPayment.click();
        }

        @FindBy(xpath = "//span[text()='UPI Options']")
        WebElement upiOptions;

        @FindBy(xpath = "//span[text()='Credit/Debit/ATM Card']")
        WebElement creditAndDebit;

        public boolean paymentPageIsDisplayed(){
               return upiOptions.isDisplayed() && creditAndDebit.isDisplayed();
        }
}
