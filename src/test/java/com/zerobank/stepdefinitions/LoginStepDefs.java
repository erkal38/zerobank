package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user landed homepage")
    public void the_user_landed_homepage() {
       Assert.assertTrue("page title is Zero-Bank...", new LoginPage().isPageAccesible());
        //any
    }

    @When("the user clicks signing button")
    public void the_signing_page_is_clickable() {
        new LoginPage().clickSignButton();

    }

    @When("the user logs in with correct credentials")
    public void the_authorized_user_enter_the() {
        new LoginPage().loginWithTrue();
        new LoginPage().loginWithWrong();


    }

    @Then("the title should be {string}")
    public void the_title_should_be(String string) {
        String actualName = Driver.get().getTitle();
        System.out.println("actualName:"+actualName);
        System.out.println("expectedName:"+string);
        Assert.assertEquals(string, actualName);

    }

    @Given("the user logged in")
        public void theUserLoggedIn() {
            new LoginPage().loginDirectly();
    }
}
