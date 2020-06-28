package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@name='user_login']")
    public WebElement userName;
    @FindBy(xpath = "//button[@class='signin btn btn-info']")
    public WebElement signIn;
    @FindBy(xpath = "//input[@name='user_password']")
    public WebElement password;
    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submit;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alertPage;

    public boolean isPageAccesible() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertTrue(Driver.get().getTitle().equals("Zero - Personal Banking - Loans - Credit Cards"));
        return Driver.get().getTitle().equals("Zero - Personal Banking - Loans - Credit Cards");
    }


    public boolean login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        if (Driver.get().getTitle().equals("Zero - Log in")) {
            String actualN = alertPage.getText();
            System.out.println("Error Message:" + actualN);
    }
        return Driver.get().getTitle().equals("Zero - Account Summary");
    }

    public boolean clickSignButton() {
        signIn.click();
        String title = Driver.get().getTitle();
        Assert.assertEquals("title is OK", "Zero - Log in", title);
        return true;
    }


    public boolean loginWithTrue() {
        boolean flag = login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
        if(flag){
            System.out.println("logged in successfully");
        }
        return flag;
    }

    public boolean loginWithWrong() {
        boolean login = login("xxxxx", "adfadsfasf");
        return login;
    }

    public boolean loginDirectly() {
        return (isPageAccesible()&clickSignButton()&loginWithTrue());
    }
}

