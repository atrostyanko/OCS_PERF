package pages.dictionaries;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class VariantPreferredPage extends MenuPage {
    @FindBy(id = "variantForm")
    private WebElement openIndicator;

    public VariantPreferredPage() {
        super(false);
    }

    public VariantPreferredPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        DictionariesMainMenu.click();
        VariantPreferredSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
