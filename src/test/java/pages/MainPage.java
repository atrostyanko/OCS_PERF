package pages;

import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends MenuPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    @FindBy(name = "submit")
    public Button submitBtn;

    @FindBy(id = "divoCMenu0_0")
    private Button menuOpenIndicator;

    @FindBy(css = "span.Note")
    private Button openIndicator;

    public MainPage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super(webDriverFactory, extentManager, false);
    }

    public MainPage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu) {
        super(webDriverFactory, extentManager, openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isSearchPageOpened() {
        return openIndicator.isDisplayed() && menuOpenIndicator.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return webDriverFactory.getTitle().equalsIgnoreCase("Main Page");
    }

    //===== Click methods ==============================================================================================
    /*
    public boolean clickSubmit() {
        return submitBtn.click();
    }
    */
}
