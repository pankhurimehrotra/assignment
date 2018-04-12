package com.axelerant.assignment.testcase;

import com.axelerant.assignment.constant.GlobalConstants;
import com.axelerant.assignment.page.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pankhuri on 11/04/18.
 */
public class ContactUsTestCase extends BaseTestCase {

    /* verify the contact us page title */
    @Test( groups = "contactPage", testName = "CP-1")
    public void testContactUsPage() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            new ContactUsPage(driver);
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testContactUsPage: " + e.getMessage() );
        }
    }

    /* verify submit form with valid entries */
    @Test( groups = "contactPage", testName = "CP-2")
    public void testSubmitContactUsForm() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            ContactUsPage contactPage = new ContactUsPage(driver);
            contactPage.submitContactUsForm(GlobalConstants.EMAIL, GlobalConstants.ORDER_REFERENCE);
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testSubmitContactUsForm: " + e.getMessage() );
        }
    }

    /* verify submit form with blank email */
    @Test( groups = "contactPage", testName = "CP-2")
    public void testSubmitContactUsForm_BlankEmail() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            ContactUsPage contactPage = new ContactUsPage(driver);
            contactPage.submitContactUsForm("", GlobalConstants.ORDER_REFERENCE);
            String message = contactPage.getBlankEmailErrorMessage();
            Assert.assertEquals(message, "Invalid email address");
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testSubmitContactUsForm_BlankEmail: " + e.getMessage() );
        }
    }

}
