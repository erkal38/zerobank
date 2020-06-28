package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountActivity extends BasePage {
    public AccountActivity(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//a[contains(text(),'Account Activity')]")
    public WebElement accountName;
    @FindBy(xpath = "//select[@name='accountId']")
    public WebElement accountTransF;
    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    public WebElement accountActivityTrans;
    @FindBy(xpath = "//input[@name='fromDate']")
    public WebElement enterDate;
    @FindBy(xpath = "//input[@name='toDate']")
    public WebElement enterToDate;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement buttonFind;
    @FindBy(xpath = "//div[@class='ui-tabs-panel ui-widget-content ui-corner-bottom']//div//td[contains(text(),'2012-09')]")
    public List<WebElement> checkTable;
    @FindBy(xpath = "//input[@name='description']")
    public WebElement descripTransaction;
    @FindBy(xpath ="//div[@class='ui-tabs-panel ui-widget-content ui-corner-bottom']//td[2]")
    public List<WebElement> descripTable;
    public WebElement statement;

    public void transFunc(String trans) {

        Driver.get().findElement(By.linkText(trans)).click();
    }
    public boolean isDropDown(String str){
            Select select=new Select(accountTransF);
            String text = select.getFirstSelectedOption().getText();
        System.out.println(text);
        return text.equals(str);

    }
     public void accessDate(String fromdate, String toDate){
        enterDate.sendKeys(fromdate);
        enterToDate.sendKeys(toDate);
     }
    }
