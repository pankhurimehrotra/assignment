package com.axelerant.assignment.page;

import com.axelerant.assignment.constant.GlobalConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by pankhuri on 11/04/18.
 */
public class NewsLetterPage extends BasePage {

    public static final String NEWSLETTER_EMAIL_LOCATOR = "id=newsletter-input";

    public static final String SUBMIT_NEWSLETTER_LOCATOR = "xpath=.//*[@id='newsletter_block_left']/div/form/div/button";

    public static final String SUCCESS_MESSAGE_LOCATOR = "xpath=.//*[@id='columns']/p";

    public NewsLetterPage(WebDriver driver){
        super(driver);
    }

    public ContactUsPage subscribeNewsletter(){

        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("scroll(0, 400);");
        getElementWithWait(NEWSLETTER_EMAIL_LOCATOR).sendKeys(GlobalConstants.EMAIL);
        getElementWithWait(SUBMIT_NEWSLETTER_LOCATOR).click();
        return new ContactUsPage(driver);

    }

    public String getSubscriptionMessage() {

        WebElement message = getElementWithWait(SUCCESS_MESSAGE_LOCATOR);
        return message.getText();
    }
}
