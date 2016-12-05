package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultPage;

/**
 * Created by KseniaB on 12/5/2016.
 */
public class SearchTests extends BaseTest {


    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                {"automation", "automation - Bing", 11}
        };
    }

    @Test(dataProvider = "searchData")
    public void performSearchTest(String searchCriteria, String expectedTitle, int expectedNumberOfArticles) {
        ResultPage resultPage = searchPage.performSearchWith(searchCriteria);
        softAssert.assertEquals(resultPage.getTitle(), expectedTitle, "Incorrect title.");
        softAssert.assertEquals(resultPage.getNumberOfResults(), expectedNumberOfArticles, "Web site showed incorrect number of results: " + resultPage.toString());
        softAssert.assertAll();
    }
}
