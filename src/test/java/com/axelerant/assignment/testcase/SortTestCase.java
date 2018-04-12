package com.axelerant.assignment.testcase;

import com.axelerant.assignment.constant.GlobalConstants;
import com.axelerant.assignment.page.SortPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pankhuri on 11/04/18.
 */
public class SortTestCase extends BaseTestCase {

    /* verify sorting by low price to high */
    @Test( groups = "sortByPrice", testName = "SP-1")
    public void testSortingByPrice() {
        try {
            driver.get(GlobalConstants.WEBSITE_URL);
            SortPage sortPage = new SortPage(driver);
            sortPage.Login(GlobalConstants.EMAIL, GlobalConstants.PASSWORD);
            boolean isResultSorted = sortPage.SortResults(GlobalConstants.SEARCH_TERM);
            Assert.assertEquals(isResultSorted,true);
            System.out.println("The results are sorted correctly");
        } catch (Exception e) {
            e.printStackTrace( System.out );
            Assert.fail( "Exception Occurred While Testing: testPlaceOrderPayByBank: " + e.getMessage() );
        }
    }
}
