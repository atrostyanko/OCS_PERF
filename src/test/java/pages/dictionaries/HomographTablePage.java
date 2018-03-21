package pages.dictionaries;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class HomographTablePage extends MenuPage {
    @FindBy(id = "homoFormMainId")
    private WebElement openIndicator;

    public HomographTablePage() {
        super(false);
    }

    public HomographTablePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        DictionariesMainMenu.click();
        HomographTableSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
