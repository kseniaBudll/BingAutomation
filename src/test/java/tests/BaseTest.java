package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.JUnitXMLReporter;
import org.uncommons.reportng.HTMLReporter;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by KseniaB on 12/5/2016.
 */
@Listeners({HTMLReporter.class, JUnitXMLReporter.class})
public abstract class BaseTest {

    protected SearchPage searchPage;
    protected SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() throws Exception{
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        searchPage = (SearchPage) new SearchPage(driver).open();
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void afterTest() {
        searchPage.getDriver().quit();
    }
}
