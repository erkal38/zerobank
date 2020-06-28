package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class AccountActivityTransStepDefs {
    @Given("the user clicks Account Activity tab")
    public void the_user_clicks_Account_Activity_tab() {

        new AccountActivity().accountName.click();
    }

    @Given("the user clicks the FindTransactions tab")
    public void the_user_clicks_the_FindTransactions_tab() {
        new AccountActivity().accountActivityTrans.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        BrowserUtils.waitFor(2);
        new AccountActivity().accessDate(string,string2);
    }

    @When("the user clicks search")
    public void the_user_clicks_search() {
        BrowserUtils.waitFor(3);
        new AccountActivity().buttonFind.click();
    }
    @When("the user checks results transaction following dates")
    public void the_user_checks_results_transaction_dates_between_to(List<String> checkTable) {
        BrowserUtils.waitFor(3);
        List<String> elementsText = BrowserUtils.getElementsText(new AccountActivity().checkTable);
        Collections.sort(elementsText);
        Collections.reverse(elementsText);
        for(int i=0;i<elementsText.size();i++){
            System.out.println(elementsText.get(i));
            System.out.println(checkTable.contains(elementsText.get(i)));
        }
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.waitFor(3);
        new AccountActivity().descripTransaction.sendKeys(string);
    }
    @Then("the user checks results description following definitons")
    public void the_user_checks_results_description_following_definitons(List<String> dataTable) {
        BrowserUtils.waitFor(3);
        List<String> elementsText = BrowserUtils.getElementsText(new AccountActivity().descripTable);
        for(int i=0;i<elementsText.size();i++) {
            System.out.println(dataTable.get(i));
            if(elementsText.contains(dataTable.get(i)))
            Assert.assertEquals(true,elementsText.contains(dataTable.get(i)));
            System.out.println("test is Ok");
        }
    }
}
