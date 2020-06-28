package com.zerobank.stepdefinitions;



import com.zerobank.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getName()+" is started...");
        System.out.println("**************");

    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        System.out.println("**************");
        Driver.closeDriver();
    }
    @Before("@db")
    public void setUpDb(){
        System.out.println("\tconnecting the db");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting from database");

    }
}

