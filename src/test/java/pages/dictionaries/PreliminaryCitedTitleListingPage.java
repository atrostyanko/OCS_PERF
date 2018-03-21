package pages.dictionaries;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class PreliminaryCitedTitleListingPage extends MenuPage {
    @FindBy(id = "beginField")
    private WebElement openIndicator;

    public PreliminaryCitedTitleListingPage() {
        super(false);
    }

    public PreliminaryCitedTitleListingPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        DictionariesMainMenu.click();
        PreliminaryCitedTitleListingSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
