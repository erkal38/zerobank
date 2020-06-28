package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AccountActivityStepDefs {

    @When("the user click {string} link on	the	Account	Summary	page")
    public void the_user_click_link_on_the_Account_Summary_page(String accountType) {
         new AccountActivity().transFunc(accountType);
        BrowserUtils.waitFor(3);


    }

    @Then("the account dropdown {string} selected")
    public void the_account_dropdown_selected(String accountType) {
        System.out.println(new AccountActivity().isDropDown(accountType));


    }
    @Then("the \"Account Activity\"should displayed")
    public void the_Account_Activity_should_displayed() {
        System.out.println(new AccountActivity().accountName.getText());
    }
}
