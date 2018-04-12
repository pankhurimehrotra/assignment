package com.axelerant.assignment.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.axelerant.assignment.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by pankhuri on 11/04/18.
 */
public class BaseTestCase {

    public WebDriver driver;

    @BeforeTest( alwaysRun = true)
    public void setUp()
    {

        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println( "-- Finished Setting up" );
        System.out.println("new comment");
    }


    @AfterTest( alwaysRun = true)
    public void tearDown()
    {
        driver.close();
        System.out.println( "-- Test Completed" );
    }
}
