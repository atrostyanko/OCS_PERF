package pages.search;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class BaseSearchPage extends MainPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    @FindBy(css = "input[src *= 'search_button.gif']")
    public Button searchButton;

    //====== Constructor ===============================================================================================
    public BaseSearchPage() {
        super(true);
    }
    public BaseSearchPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //====== Get Methods ===============================================================================================
    public String getSelectedOption() {
        WebElement webElement = WebDriverFactory.findElement(By.cssSelector("input[name='section'][checked='checked']"));
        if (webElement != null) {
            return webElement.getAttribute("value");
        }
        return "";
    }
}
