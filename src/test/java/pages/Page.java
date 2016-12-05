package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by KseniaB on 12/5/2016.
 */
public abstract class Page {

    protected final WebDriver driver;
    protected static final String BASE_URL = ResourceBundle.getBundle("configuration/application").getString("APP_URL");

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Page open() {
        driver.get(BASE_URL);
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected List<String> getListOfStrings(List<WebElement> list) {
        List<String> strings = new ArrayList<String>();
        for (WebElement element: list) {
            strings.add(element.getText());
        }
        return strings;
    }
}
