package pages.journalMaintenance;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class CreateNewJournalPage extends MenuPage {
    @FindBy(id = "jrnlEditMainId")
    private WebElement openIndicator;

    public CreateNewJournalPage() {
        super(false);
    }

    public CreateNewJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        JournalMaintenanceMainMenu.click();
        CreateNewJournalSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
