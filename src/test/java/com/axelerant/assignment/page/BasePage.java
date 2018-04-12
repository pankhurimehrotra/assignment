package com.axelerant.assignment.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by pankhuri on 11/04/18.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage( WebDriver driver )
    {
        this.driver = driver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    /**
     * Given a string locator, returns a list of elements.
     *
     * @param locator
     * @return
     */
    public List<WebElement> getElements(String locator )
    {

        List<WebElement> elements = driver.findElements( getLocator( locator ) );

        return elements;
    }

    /**
     * Given a string locator, returns the element.
     *
     * @param locator
     * @return
     */
    public WebElement getElement( String locator )
    {
        WebElement element = driver.findElement( getLocator( locator ) );

        return element;
    }

    public WebElement getElementWithWait( String locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locator)));
        return element;
    }

    public By getLocator(String locator )
    {
        By by = null;
        String newLocator = locator.substring( locator.indexOf( "=" ) + 1 );

        if ( locator.startsWith( "id" ) ) {
            by = By.id( newLocator );
        } else if ( locator.startsWith( "name" ) ) {
            by = By.name( newLocator );
        } else if ( locator.startsWith( "css" ) ) {
            by = By.cssSelector( newLocator );
        } else if ( locator.startsWith( "link" ) ) {
            by = By.linkText( newLocator );
        } else if ( locator.startsWith( "xpath" ) ) {
            by = By.xpath( newLocator );
        } else if ( locator.startsWith( "partiallink" ) ) {
            by = By.partialLinkText( newLocator );
        } else if ( locator.startsWith( "tagname" ) ) {
            by = By.tagName( newLocator );
        } else {
            throw new IllegalArgumentException( "Locator not recognised: " + locator );
        }
        return by;
    }

}
