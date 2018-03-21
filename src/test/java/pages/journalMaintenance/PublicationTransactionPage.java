package pages.journalMaintenance;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class PublicationTransactionPage extends MenuPage {
    @FindBy(id = "searchField")
    private WebElement openIndicator;

    public PublicationTransactionPage() {
        super(false);
    }

    public PublicationTransactionPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        JournalMaintenanceMainMenu.click();
        PublicationTransactionSubMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
