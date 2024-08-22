package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage=new HomePage();

    @Given("user open goibibo website")
    public void user_open_goibibo_website() {
        homePage.openWebsite();

    }

}
