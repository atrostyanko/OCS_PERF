package pages.journalMaintenance;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class IssnPage extends MenuPage {
    @FindBy(id = "issnData")
    private WebElement openIndicator;

    public IssnPage() {
        super(false);
    }

    public IssnPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        JournalMaintenanceMainMenu.click();
        ISSNSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
