package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummary {

    public AccountSummary(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;
    @FindBy(xpath = "//div[3]//div[1]//table[1]//thead[1]//tr[1]//th")
    public List<WebElement> subAccounts;

    public boolean isAccountTypeIncluded(List<String> types) {
            boolean flag = false;
            for (String type : types) {
                flag= isAccountTypeIncluded(type);
                if (!flag){
                    System.out.println(type+" is missing");
                }
            }
            return flag;
    }

    public boolean isAccountTypeIncluded(String type) {

        return BrowserUtils.getElementsText(accountTypes).contains(type);
    }

    public boolean isTitlesIncluded(List<String> titles) {
        boolean flag=true;
        for (String title : titles) {
           flag=isTitlesIncluded(title);
            if(!flag){
                System.out.println(title+" is missing");
            }

        }
      return flag;
    }

    public boolean isTitlesIncluded(String title) {

        return BrowserUtils.getElementsText(subAccounts).contains(title);
    }

}
