package pages.dictionaries;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class FirstSecondWordPage extends MenuPage {
    @FindBy(id = "searchField")
    private WebElement openIndicator;

    public FirstSecondWordPage() {
        super(false);
    }

    public FirstSecondWordPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        DictionariesMainMenu.click();
        FirstSecondWordSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
