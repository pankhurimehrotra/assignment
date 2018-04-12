package com.axelerant.assignment.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pankuri on 11/04/18.
 */
public class DriverFactory {

    public static WebDriver getDriver() {
        System.setProperty("webdriver.firefox.marionette", "Users/Pankuri/Downloads/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

}
