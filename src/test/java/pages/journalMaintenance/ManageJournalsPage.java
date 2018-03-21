package pages.journalMaintenance;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.MenuPage;

public class ManageJournalsPage extends MenuPage {
    @FindBy(id = "seqNumber")
    private WebElement openIndicator;

    public ManageJournalsPage() {
        super(false);
    }

    public ManageJournalsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        JournalMaintenanceMainMenu.click();
        ManageJournalsSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
