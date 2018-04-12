package com.axelerant.assignment.testcase;

import com.axelerant.assignment.constant.GlobalConstants;
import com.axelerant.assignment.page.PlaceOrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by pankhuri on 11/04/18.
 */
public class PlaceOrderTestCase extends BaseTestCase {

    /* verify the login page title */
    @Test( groups = "loginPage", testName = "LP-1")
    public void testLoginPageTitle() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            new PlaceOrderPage(driver);
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testLoginPageTitle: " + e.getMessage() );
        }
    }

    /* verify checkout and pay by bank */
    @Test( groups = "placeOrderPage", testName = "PO-1")
    public void testPlaceOrderPayByBank() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
            placeOrderPage.LoginAndPlaceOrder(GlobalConstants.EMAIL, GlobalConstants.PASSWORD, GlobalConstants.SEARCH_TERM);
            String successMessage = placeOrderPage.PlaceOrderPayByBank();
            Assert.assertEquals(successMessage, "Your order on My Store is complete.");
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testPlaceOrderPayByBank: " + e.getMessage() );
        }
    }

    /* verify checkout and pay by cheque */
    @Test( groups = "placeOrderPage", testName = "PO-2")
    public void testPlaceOrderPayByCheck() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
            placeOrderPage.LoginAndPlaceOrder(GlobalConstants.EMAIL, GlobalConstants.PASSWORD, GlobalConstants.SEARCH_TERM);
            String successMessage = placeOrderPage.PlaceOrderPayByCheque();
            Assert.assertEquals(successMessage, "Your order on My Store is complete.");
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testPlaceOrderPayByCheck: " + e.getMessage() );
        }
    }
}
