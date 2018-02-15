package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "span.Note")
    private Button openIndicator;

    @FindBy(xpath = ".//div[.= 'PUBLISHER']")
    private Button publisherMenu;

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
        return openIndicator.isDisplayed();
    }

    //===== Set methods ================================================================================================
}
