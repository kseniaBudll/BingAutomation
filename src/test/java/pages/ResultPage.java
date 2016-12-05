package pages;

import com.google.common.base.Joiner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by KseniaB on 12/5/2016.
 */
public class ResultPage extends Page {

    @FindBy(id = "b_results")
    private WebElement parentElement;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResults() {
        return getListOfResultsHeaders().size();
    }

    /**
     * Method returns headers list of results.
     */
    @Override
    public String toString() {
        return "List of results: " + Joiner.on(", ").join(getListOfStrings(getListOfResultsHeaders()));
    }

    private List<WebElement> getListOfResultsHeaders() {
        return parentElement.findElements(By.xpath(".//h2"));
    }
}
