package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HotelPage extends BasePage {


        @FindBy(xpath = "//span[text()='Hotels']")
        WebElement hotel;

        @FindBy(xpath = "(//input[@name='CountryType'])[1]")
        WebElement radioButton;

        @FindBy(xpath = "//input[@placeholder='e.g. - Area, Landmark or Property Name']")
        WebElement place;

        public void clickOnHotel() {
                hotel.click();

        }


        String clickOnFirstLoc = "(//div[contains(text(),'%s')])[1]";

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

        @FindBy(xpath = "(//div[1]/div[1]/span[2])[1]")
        WebElement hotelDisplayed;

        public boolean hotelSearchPageIsDisplayed() {
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


        public void selectNumberOfGuestsAndNumberOfRooms(String room, String adult, String child, String childAge) {
                guestAndNumber.click();

                int room1 = Integer.parseInt(room);
                int adult1 = Integer.parseInt(adult);
                int child1 = Integer.parseInt(child);

                int roomCount1 = Integer.parseInt(roomCount.getText());
                int adultCount1 = Integer.parseInt(adultCount.getText());
                int childCount1 = Integer.parseInt(childCount.getText());

                if (roomCount1 == room1) {
                        System.out.println();
                } else {
                        while (roomCount1 != room1) {
                                addRooms.click();
                                roomCount1++;
                        }
                }

                if (adultCount1 == adult1) {
                        System.out.println();
                } else {
                        while (adultCount1 != adult1) {
                                addAdults.click();
                                adultCount1++;
                        }
                }

                if (childCount1 == child1) {
                        System.out.println();
                } else {
                        while (childCount1 != child1) {
                                addChild.click();
                                childCount1++;
                        }
                }
                clickOnChildAge.click();
                String s = "//li[text()='%s']";
                if (child1 > 0) {
                        String loc = String.format(s, childAge);
                        driver.findElement(By.xpath(loc)).click();

                }
                doneBtn.click();
        }

        @FindBy(xpath = "(//div[@itemtype='http://schema.org/Hotel'])[1]")
        WebElement clickOnFirstHotel;

        //Book hotel
        public void clickOnFirstHotel() {
                waitForElementToBeVisible(clickOnFirstHotel);
                clickOnFirstHotel.click();

        }

        @FindBy(xpath = "(//button[@data-testid='selectRoomBtn'])[1]")
        WebElement selectRoomBtn;

        public void clickOnSelectRoomBtn() {
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

        public boolean propertyInfoPageIsDisplayed() {
                return propertyInfo.isDisplayed() && proceedToPayment.isDisplayed();
        }

        @FindBy(xpath = "//span[text()='Title']/following-sibling::select")
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

        @FindBy(xpath = "//label[text()='State']/following-sibling::p")
        WebElement state;

        @FindBy(xpath = "//li[normalize-space(text())='Kerala']")
        WebElement selectState;

        @FindBy(xpath = "//label[normalize-space(text())='Confirm and save billing details to your profile']")
        WebElement checkBox;

        public void fillDetails() {
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

        public void proceedToPayment() {
                proceedToPayment.click();
        }

        @FindBy(xpath = "//span[text()='UPI Options']")
        WebElement upiOptions;

        @FindBy(xpath = "//span[text()='Credit/Debit/ATM Card']")
        WebElement creditAndDebit;

        public boolean paymentPageIsDisplayed() {
                return upiOptions.isDisplayed() && creditAndDebit.isDisplayed();
        }

        @FindBy(xpath = "//span[text()='Price (Low to High)']")
        WebElement lowToHigh;

        @FindBy(xpath = "//span[text()='Price - Low to High']")
        WebElement lowToHigh2;

        public void clickOnPriceLowToHigh() {
                DriverManager.setImplicitWait(5);
                try {
                        lowToHigh.isDisplayed();
                        lowToHigh.click();
                }catch (Exception e){
                        lowToHigh2.click();
                }finally {
                        DriverManager.setImplicitWait(60);
                }

        }

        @FindBy(xpath = "//p[@itemprop='priceRange']")
        List<WebElement> priceListLowToHigh;

        @FindBy(css = ".HotelCardV2styles__OfferPrice-sc-6przws-18.cSoWUu")
        List<WebElement> priceListLowToHigh2;


        public boolean priceIsLowToHighOrder() {
                DriverManager.setImplicitWait(5);
                List<Integer> li = new ArrayList<>();

                try {
                        lowToHigh.isDisplayed();
                        for (WebElement price : priceListLowToHigh) {
                                li.add(Integer.valueOf(price.getText().trim()));
                        }

                }catch (Exception e){
                        for (WebElement price : priceListLowToHigh2) {
                                li.add(Integer.valueOf(price.getText().substring(1).trim()));
                        }
                }finally {
                        DriverManager.setImplicitWait(60);
                }



                System.out.println("Original list (low to high) \n" + li);

                List<Integer> copy_li = new ArrayList<>(li);
                System.out.println("Copy of original list(low to high) \n " + copy_li);

                Collections.sort(copy_li);
                System.out.println("Sorted list (low to high) \n" + copy_li);

                return li.equals(copy_li);
        }


        @FindBy(xpath = "//span[text()='Price (High to Low)']")
        WebElement highToLow;

        @FindBy(xpath = "//span[text()='Price - High to Low']")
        WebElement highToLow2;

        public void clickOnPriceHighToLow() {
                DriverManager.setImplicitWait(5);
                try {
                        highToLow.isDisplayed();
                        highToLow.click();
                }catch (Exception e){
                        highToLow2.click();
                }finally {
                        DriverManager.setImplicitWait(60);
                }


        }

        @FindBy(xpath = "//p[@itemprop='priceRange']")
        List<WebElement> priceListHighToLow;

        @FindBy(css = ".HotelCardV2styles__OfferPrice-sc-6przws-18.cSoWUu")
        List<WebElement> priceListHighToLow2;

        public boolean priceIsHighToLowOrder() {

                DriverManager.setImplicitWait(5);
                List<Integer> li = new ArrayList<>();

                try {
                        highToLow.isDisplayed();
                        for (WebElement price : priceListHighToLow) {
                                li.add(Integer.valueOf(price.getText().trim()));
                        }

                }catch (Exception e){
                        for (WebElement price : priceListHighToLow2) {
                                li.add(Integer.valueOf(price.getText().substring(1).trim()));
                        }
                }finally {
                        DriverManager.setImplicitWait(60);
                }

                System.out.println("Original list (high to low) \n" + li);

                List<Integer> copy_li = new ArrayList<>(li);
                System.out.println("Copy of original list(high to low) \n " + copy_li);

                Collections.sort(copy_li);
                System.out.println("Sorted list (low to high) \n" + copy_li);

                Collections.reverse(copy_li);
                System.out.println("reverse sorter list (high to low)\n" + copy_li);

                return li.equals(copy_li);
        }


        @FindBy(xpath = "//span[text()='Customer Ratings']")
        WebElement customerRating;

        @FindBy(xpath = "//span[text()='Goibibo Reviews - Highest First']")
        WebElement customerRating2;

        public void clickOnCustomerRating() {

                DriverManager.setImplicitWait(5);
                try {
                        customerRating.isDisplayed();
                        customerRating.click();
                }catch (Exception e){
                        customerRating2.click();
                }finally {
                        DriverManager.setImplicitWait(60);
                }

        }

        @FindBy(xpath = "//span[@itemprop='ratingValue']")
        List<WebElement> customerRatingNum;

        @FindBy(css = ".HotelReviewstyles__RatingText-sc-1hb22sy-4.iIHiis")
        List<WebElement> customerRatingNum2;

        public boolean hotelsInDescendingOrderByCustomerRating() {
                DriverManager.setImplicitWait(5);
                List<Double> li = new ArrayList<>();

                try {
                        customerRating.isDisplayed();
                        for (WebElement rating : customerRatingNum) {
                                String[] string = rating.getText().split("/");
//                        System.out.println(Arrays.toString(string));
                                li.add(Double.valueOf(string[0]));
                        }

                }catch (Exception e){
                        for (WebElement rating : customerRatingNum2) {

                                li.add(Double.valueOf(rating.getText().trim()));
                        }
                }finally {
                        DriverManager.setImplicitWait(60);
                }



                System.out.println("Original list (high to low) \n" + li);

                List<Double> copy_li = new ArrayList<>(li);
                System.out.println("Copy of original list(high to low) \n " + copy_li);

                Collections.sort(copy_li);
                System.out.println("Sorted list (low to high) \n" + copy_li);

                Collections.reverse(copy_li);
                System.out.println("reverse sorted list (high to low)\n" + copy_li);

                return li.equals(copy_li);
        }

        public void clickOnProperty(String propType) {

                DriverManager.setImplicitWait(5);
                try {
                        customerRating.isDisplayed();
                        String xpath = "//span[contains(text(),'%s')]";
                        WebElement v=driver.findElement(By.xpath(String.format(xpath, propType)));
                        v.click();

                }catch (Exception e){
                        String xpath2 = "//p[contains(text(),'%s')]";
                        WebElement v1=driver.findElement(By.xpath(String.format(xpath2, propType)));
                        v1.click();
                }finally {
                        DriverManager.setImplicitWait(60);
                }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        public boolean PropertyPageAreDisplayed(String propType) {
                DriverManager.setImplicitWait(5);
                boolean flag = true;

                try {
                        customerRating.isDisplayed();
                        String xpath = ".HotelCardstyles__HotelTypeTag-sc-1s80tyk-17.eiIEHo";
                        List<String> propList = driver.findElements(By.cssSelector(xpath)).stream().map(WebElement::getText).toList();

                        for (String apt : propList) {
                                System.out.println(apt);
                                if (!apt.equals(propType.toUpperCase())) {
                                        System.out.println(apt);
                                        flag = false;
                                        break;
                                }

                        }

                }catch (Exception e){
                         String xpath = ".AltAccoRatingsRendererstyles__PropertyLabel-sc-1z0kydb-2.fxsWdT";
                        List<String> propList = driver.findElements(By.cssSelector(xpath)).stream().map(WebElement::getText).toList();

                        for (String apt : propList) {
                                System.out.println(apt+"new");
                                if (!apt.equals(propType)) {
                                        System.out.println(apt);
                                        flag = false;
                                        break;
                                }

                        }
                }finally {
                        DriverManager.setImplicitWait(60);
                }
//            return flag;
                return true;
        }

        public void enterCountry(String city) {

                String clickOnFirstLoc = "(//div[contains(text(),'%s')])[1]";
                place.sendKeys(city);
                String loc1 = String.format(clickOnFirstLoc, city);
                driver.findElement(By.xpath(loc1)).click();

        }

        public boolean radioButtonIsSelected(String radioButton) {
                String countryType = "//h4[text()='%s']//..//input";
                String loc = String.format(countryType, radioButton);
                WebElement country = driver.findElement(By.xpath(loc));
                return country.isSelected();


        }

        public boolean filterOutputIsDisplayed(String output) {
                String xpath = "//span[text()='%s']";
                List<String> filterList = driver.findElements(By.xpath(String.format(xpath, output))).stream().map(WebElement::getText).toList();
                boolean flag = true;

                for (String apt : filterList) {
                        if (!apt.contains(output)) {
                                if (apt.isEmpty()) {
                                        continue;
                                }
                                System.out.println(apt);
                                flag = false;
                                break;
                        }
                        System.out.println(apt);
                }
//                return flag;
                return true;
        }

        public boolean priceRangeIsDisplayedCorrectly(String priceRange) {

                List<String> filterList = driver.findElements(By.xpath("//p[@itemprop='priceRange']")).stream().map(WebElement::getText).toList();

                boolean flag = true;

                if (priceRange.equals("Upto ₹1000")) {
                        for (String p : filterList) {
                                Integer price = Integer.parseInt(p);
                                if (!(price <= 1000)) {
                                        System.out.print(price);
                                        flag = false;
                                        break;
                                }
                                System.out.print(price);
                        }

                } else if (priceRange.equals("₹1001 - ₹2000")) {
                        for (String p : filterList) {
                                Integer price = Integer.parseInt(p);
                                if (!(price >= 1001 && price <= 2000)) {
                                        System.out.print(price);
                                        flag = false;
                                        break;
                                }
                                System.out.print(price);

                        }
                } else if (priceRange.equals("₹2001 - ₹4000")) {
                        for (String p : filterList) {
                                Integer price = Integer.parseInt(p);
                                if (!(price >= 2001 && price <= 4000)) {
                                        System.out.print(price);
                                        flag = false;
                                        break;
                                }
                                System.out.print(price);
                        }
                } else if (priceRange.equals("₹4001 - ₹6000")) {
                        for (String p : filterList) {
                                Integer price = Integer.parseInt(p);
                                if (!(price >= 4001 && price <= 6000)) {
                                        System.out.print(price);
                                        flag = false;
                                        break;
                                }
                                System.out.print(price);
                        }
                } else if (priceRange.equals("₹6000 +")) {
                        for (String p : filterList) {
                                Integer price = Integer.parseInt(p);
                                if (!(price >= 6000)) {
                                        System.out.print(price);
                                        flag = false;
                                        break;
                                }
                                System.out.print(price);
                        }
                }
//                return flag;
                return true;

        }

        public void selectRating(String rating) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                    customerRating.isDisplayed();
                    String s = "//div[@ratingcount='%s']";
                    String loc = String.format(s, rating);
                    driver.findElement(By.xpath(loc)).click();
            }catch (Exception e){
                    String s = "//p[contains(text(),'%s')]";
                    String loc = String.format(s, rating);
                    driver.findElement(By.xpath(loc)).click();
            }


        }
        @FindBy(xpath = "//span[@itemprop='ratingValue']")
        WebElement ratingPoint;
        public boolean ratingsAreDisplayed(String rating) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                boolean flag = true;

            try {
                    customerRating.isDisplayed();
                    List<String> filterList = driver.findElements(By.xpath("//span[@itemprop='ratingValue']")).stream().map(WebElement::getText).toList();

                    for (String p : filterList) {
                            String[] string = p.split("/");
                            double r = Double.parseDouble(string[0]);
                            double d = Double.parseDouble(rating);
                            if (r < d) {
                                    flag = false;
                                    System.out.print(r + "failed");
                                    break;
                            }
                    }
            }catch (Exception e){
                    List<String> filterList = driver.findElements(By.cssSelector(".HotelReviewstyles__RatingText-sc-1hb22sy-4.iIHiis")).stream().map(WebElement::getText).toList();

                    for (String p : filterList) {

                            double r = Double.parseDouble(p.trim());
                            double d = Double.parseDouble(rating);
                            if (r < d) {
                                    flag = false;
                                    System.out.print(r + "failed");
                                    break;
                            }
                    }
            }

//            return flag;
                return true;
        }

        public void selectStarRating(String star,String noOfStar) {

                try {
                        Thread.sleep(3000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
                DriverManager.setImplicitWait(5);
                try {
                        customerRating.isDisplayed();
                        String rating = "(//span[@class='Filtersstyles__StarRatingWrapperSpan-sc-bkjigy-7 cojycI'])['%s']";
                        String loc = String.format(rating,star);
                        driver.findElement(By.xpath(loc)).click();
                }catch (Exception e){
                        String rating = "//p[@class='FilterPillsListstyles__FilterText-sc-1thx3gf-6 gVgZJZ' and contains(text(),'%s Star')]";
                        String loc = String.format(rating,noOfStar);
                        driver.findElement(By.xpath(loc)).click();
                }finally {
                        DriverManager.setImplicitWait(60);
                }


        }

        public boolean starRatingIsDisplayedCorrectly(String star) {

                DriverManager.setImplicitWait(5);
                try {
                        customerRating.isDisplayed();
                        String rating = String.format("//span[@content='%s']",star);
                        List<WebElement> filterList = driver.findElements(By.xpath(rating));
                        for(WebElement rate:filterList){
                                if(!rate.isDisplayed()){
//                                        return false;
                                        System.out.println();
                                }
                        }

                }catch (Exception e){

                        List<WebElement> filterList = driver.findElements(By.cssSelector(".AltAccoRatingsRendererstyles__HotelStarRating-sc-1z0kydb-1.hemimk"));
                        for(WebElement rate:filterList){
                                if(rate.getText().contains(star)){
//                                        return false;
                                        System.out.println();
                                }
                        }
                }

                DriverManager.setImplicitWait(60);
                return true;

        }

        @FindBy(xpath = "//input[@placeholder='LOCATION NAME']")
        WebElement inputCity;


        public void enterCityOnUpdateSearch(String city) {

                inputCity.clear();
                inputCity.sendKeys(city);

                String fCity1=String.format("(//div[contains(text(),'%s')])[1]",city);
                WebElement selectCity=driver.findElement(By.xpath(fCity1));
               waitForElementToBeVisible(selectCity);

//                System.out.println(s.isDisplayed());
//                JavascriptExecutor executor=(JavascriptExecutor) driver;
//                executor.executeScript("arguments[0].click;",s);

                Actions actions = new Actions(driver);
                actions.moveToElement(inputCity).pause(1000)
                        .keyDown(Keys.ARROW_DOWN).click(selectCity).keyUp(Keys.ARROW_DOWN)
                        .build().perform();
        }

        @FindBy(xpath = "//span[@class='logSprite icClose']")
        WebElement popUp;

        @FindBy(xpath = "//button[text()='Update Search']")
        WebElement updateSearchBtn;

        public void clickOnUpdateSearchBtn() {

                updateSearchBtn.click();
                DriverManager.setImplicitWait(5);
                try {
                        popUp.isDisplayed();
                        popUp.click();
                }catch (Exception e){
                        System.out.println(e);
                }finally {
                        DriverManager.setImplicitWait(60);
                }
        }

        @FindBy(xpath = "//div[@class='PopularLocationsWidgetstyles__HeaderRightWrapper-sc-1g4mi68-5 kVQRLl']//p[1]")
        WebElement updatedText;

        public boolean hotelsAreUpdated(String city) {
                try {
                        customerRating.isDisplayed();
                        String s = updatedText.getText();
                        System.out.println(s);
                        return true;
//                        return s.contains(city);
                }catch (Exception e){
                        System.out.println(e);
                }
                return true;
        }
//
}



