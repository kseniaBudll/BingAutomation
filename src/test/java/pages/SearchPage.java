package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by KseniaB on 12/5/2016.
 */
public class SearchPage extends Page {

    @FindBy(id = "sb_form_q")
    private WebElement searchInput;

    @FindBy(id = "sb_form_go")
    private WebElement searchBtn;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage performSearchWith(String criteria) {
        searchInput.clear();
        searchInput.sendKeys(criteria);
        searchBtn.click();
        return new ResultPage(driver);
    }
}
