package com.axelerant.assignment.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * Created by pankhuri on 11/04/18.
 */
public class PlaceOrderPage extends BasePage {

    public static final String LOGIN_PAGE_TITLE = "Login - My Store";

    public static final String EMAIL_LOCATOR = "id=email";

    public static final String PASSWORD_LOCATOR = "id=passwd";

    public static final String SIGN_IN_BUTTON_LOCATOR = "id=SubmitLogin";

    public static final String SEARCH_LOCATOR = "id=search_query_top";

    public static final String SELECTED_PRODUCT_LOCATOR = "xpath=.//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img";

    public static final String ADD_TO_CART_LOCATOR = "xpath=.//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span";

    public static final String CHECKOUT_LOCATOR = "xpath=.//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span";

    public static final String PROCEED_CHECKOUT_LOCATOR = "xpath=.//*[@id='center_column']/p[2]/a[1]/span";

    public static final String NEXT_CHECKOUT_LOCATOR = "xpath=.//*[@id='center_column']/form/p/button";

    public static final String CHECKBOX_LOCATOR = "id=cgv";

    public static final String FINAL_CHECKOUT_BUTTON_LOCATOR = "xpath=.//*[@id='form']/p/button";

    public static final String PAYMENT_BY_BANK_LOCATOR = "xpath=.//*[@id='HOOK_PAYMENT']/div[1]/div/p/a/span";

    public static final String PAYMENT_BY_CHEQUE_LOCATOR = "xpath=.//*[@id='HOOK_PAYMENT']/div[2]/div/p/a/span";

    public static final String CONFIRM_ORDER_LOCATOR = "xpath=.//*[@id='cart_navigation']/button";

    public static final String ORDER_CONFIRMATION_BY_CHEQUE_LOCATOR = "xpath=.//*[@id='center_column']/p[1]";

    public static final String ORDER_CONFIRMATION_BY_BANK_LOCATOR = "xpath=.//*[@id='center_column']/div/p/strong";


    public PlaceOrderPage(WebDriver driver)
    {
        super(driver);

        if ( !getTitle().equals( LOGIN_PAGE_TITLE ) ) {
            Assert.fail( "This is not login page. Current page is: " + getTitle() );
        }
    }

    public SortPage LoginAndPlaceOrder(String email, String password, String searchTerm) {

        /* Login to the website */
        getElementWithWait(EMAIL_LOCATOR).sendKeys(email);
        getElementWithWait(PASSWORD_LOCATOR).sendKeys(password);
        getElementWithWait(SIGN_IN_BUTTON_LOCATOR).click();

        /* Search a product and add to Cart */
        getElementWithWait(SEARCH_LOCATOR).sendKeys(searchTerm);
        getElementWithWait(SEARCH_LOCATOR).sendKeys(Keys.RETURN);
        Actions action = new Actions(driver);
        WebElement selected_Product = getElement(SELECTED_PRODUCT_LOCATOR);
        action.moveToElement(selected_Product).build().perform();
        getElementWithWait(ADD_TO_CART_LOCATOR).click();

        /* Proceed to checkout */
        getElementWithWait(CHECKOUT_LOCATOR).click();
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("scroll(0, 250);");
        getElementWithWait(PROCEED_CHECKOUT_LOCATOR).click();
        js.executeScript("scroll(0, 250);");
        getElementWithWait(NEXT_CHECKOUT_LOCATOR).click();
        getElementWithWait(CHECKBOX_LOCATOR).click();
        getElementWithWait(FINAL_CHECKOUT_BUTTON_LOCATOR).click();
        return new SortPage(driver);
    }

    public String PlaceOrderPayByBank()
    {
        getElementWithWait(PAYMENT_BY_BANK_LOCATOR);
        getElementWithWait(CONFIRM_ORDER_LOCATOR).click();
        WebElement message = getElementWithWait(ORDER_CONFIRMATION_BY_BANK_LOCATOR);
        return message.getText();
    }

    public String PlaceOrderPayByCheque()
    {
        getElementWithWait(PAYMENT_BY_CHEQUE_LOCATOR);
        getElementWithWait(CONFIRM_ORDER_LOCATOR).click();
        WebElement message = getElementWithWait(ORDER_CONFIRMATION_BY_CHEQUE_LOCATOR);
        return message.getText();
    }

}
