package com.axelerant.assignment.page;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

/**
 * Created by pankhuri on 11/04/18.
 */
public class SortPage extends BasePage {

    public static final String EMAIL_LOCATOR = "id=email";

    public static final String PASSWORD_LOCATOR = "id=passwd";

    public static final String SIGN_IN_BUTTON_LOCATOR = "id=SubmitLogin";

    public static final String SEARCH_LOCATOR = "id=search_query_top";

    public static final String SORT_DROPDOWN_LOCATOR = "id=selectProductSort";

    public static final String PRICE_LOCATOR = "css=div[class^='product-container'] span.price product-price";

    public SortPage(WebDriver driver){

        super(driver);
    }


    public void Login(String email, String password)
    {
        getElementWithWait(EMAIL_LOCATOR).sendKeys(email);
        getElementWithWait(PASSWORD_LOCATOR).sendKeys(password);
        getElementWithWait(SIGN_IN_BUTTON_LOCATOR).click();
    }

    public boolean SortResults(String searchTerm)
    {

        getElementWithWait(SEARCH_LOCATOR).sendKeys(searchTerm);
        getElementWithWait(SEARCH_LOCATOR).sendKeys(Keys.RETURN);

        /* Get all the price elements in a list */
        List<WebElement> price = getElements(PRICE_LOCATOR);

        /* Store the price text from all the elements in an array list */
        List<String> priceList = new ArrayList<String>();
        for (WebElement e : price) {
            priceList.add(e.getText());
        }

        /* Select sort by low price to high  */
        Select sortDropdown = new Select(getElement(SORT_DROPDOWN_LOCATOR));
        sortDropdown.selectByIndex(1);

        /* Get all the sorted price elements in a list */
        List<WebElement> sortedPrice = getElements(PRICE_LOCATOR);

        /* Store the sorted price text from all the elements in an array list */
        List<String> sortedPriceList = new ArrayList<String>();
        for (WebElement e : price) {
            priceList.add(e.getText());
        }

        boolean isSorted = verifySorting(priceList, sortedPriceList);
        return isSorted;
    }

    public boolean verifySorting(List<String> originalList, List<String> sortedList){
        // sort the originalList list
        Collections.sort(originalList);

        if(originalList.equals(sortedList)) {
            return true;
        }
        else return false;
    }
}

