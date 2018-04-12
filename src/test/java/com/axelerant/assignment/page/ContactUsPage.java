package com.axelerant.assignment.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by pankhuri on 11/04/18.
 */
public class ContactUsPage extends BasePage {

    public static final String CONTACT_LINK = "id=contact-link";

    public static final String CONTACT_PAGE_TITLE = "Contact us - My Store";

    public static final String DROPDOWN_LOCATOR = "id=uniform-id_contact";

    public static final String DROPDOWN_VALUE = "xpath=.//*[@id='id_contact']/option[2]";

    public static final String EMAIL_LOCATOR = "id=email";

    public static final String ORDER_LOCATOR = "id=id_order";

    public static final String UPLOAD_FILE_LOCATOR = "id=fileUpload";

    public static final String FILE_TO_UPLOAD = "Users/pankuri/Downloads/TestFile.png";

    public static final String SUBMIT_BUTTON_LOCATOR = "id=submitMessage";

    public static final String BLANK_EMAIL_ERROR_LOCATOR = "xpath=.//*[@id='center_column']/div/ol/li";

    public ContactUsPage(WebDriver driver)
    {
        super(driver);

        getElement(CONTACT_LINK).click();

        if ( !getTitle().equals( CONTACT_PAGE_TITLE ) ) {
            Assert.fail( "This is not contact us page. Current page is: " + getTitle() );
        }
    }

    public PlaceOrderPage submitContactUsForm(String email, String orderReference){
        getElementWithWait(DROPDOWN_LOCATOR).click();
        getElementWithWait(DROPDOWN_VALUE).click();
        getElementWithWait(EMAIL_LOCATOR).sendKeys(email);
        getElementWithWait(ORDER_LOCATOR).sendKeys(orderReference);
        getElementWithWait(UPLOAD_FILE_LOCATOR).sendKeys(FILE_TO_UPLOAD);
        getElementWithWait(SUBMIT_BUTTON_LOCATOR).click();
        return new PlaceOrderPage(driver);
    }

    public String getBlankEmailErrorMessage()
    {
        WebElement message = getElementWithWait(BLANK_EMAIL_ERROR_LOCATOR);
        return message.getText();
    }

}
