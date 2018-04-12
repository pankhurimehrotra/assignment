package com.axelerant.assignment.testcase;

import com.axelerant.assignment.constant.GlobalConstants;
import com.axelerant.assignment.page.NewsLetterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pankhuri on 11/04/18.
 */
public class NewsLetterTestCase extends BaseTestCase {

    /* Verify successful subscription to newsletter */
    @Test( groups = "newsletter", testName = "NL-1")
    public void testNewsletterSubscription(){
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            NewsLetterPage newsletter = new NewsLetterPage(driver);
            newsletter.subscribeNewsletter();
            String message = newsletter.getSubscriptionMessage();
            Assert.assertEquals(message, "Newsletter : You have successfully subscribed to this newsletter.");
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testNewsletterSubscription: " + e.getMessage() );
        }
    }
}
