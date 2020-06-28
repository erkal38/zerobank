package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    @Then("the account summary following account types")
    public void the_account_summary_following_subtitles(List<String> types) {

        Assert.assertTrue("account type included", new AccountSummary().isAccountTypeIncluded(types));
    }

    @Then("the {string} section should contain following titles")
    public void theSectionShouldContainFollowingTitles(String accountSection, List<String> titles) {

        Assert.assertTrue("title is included", new AccountSummary().isTitlesIncluded(titles));
    }
}
