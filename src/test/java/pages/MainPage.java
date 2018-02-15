package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends MenuPage {
    @FindBy(id = "divoCMenu0_0")
    private Button menuOpenIndicator;

    @FindBy(css = "span.Note")
    @CacheLookup
    private Button openIndicator;

    @FindBy(xpath = ".//div[.= 'PUBLISHER']")
    @CacheLookup
    private Button publisherMenu;

    @FindBy(name = "submit")
    @CacheLookup
    public Button submitBtn;

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
    public boolean isPageOpened() {
        return openIndicator.isDisplayed() && menuOpenIndicator.isDisplayed();
    }

    //===== Set methods ================================================================================================

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click();
    }

}
