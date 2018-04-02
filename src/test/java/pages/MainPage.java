package pages;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends MenuPage {
    @FindBy(name = "submit")
    @CacheLookup
    public Button submitBtn;

    @FindBy(id = "divoCMenu0_0")
    private Button menuOpenIndicator;

    @FindBy(css = "span.Note")
    @CacheLookup
    private Button openIndicator;

    public MainPage() {
        super(false);
    }

    public MainPage(boolean openFromMenu) {
        super(openFromMenu);
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
        return WebDriverFactory.getTitle().equalsIgnoreCase("Main Page");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click();
    }


}
