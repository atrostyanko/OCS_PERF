package pages;

import com.google.errorprone.annotations.Var;
import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.dictionaries.FirstSecondWordPage;
import pages.dictionaries.HomographTablePage;
import pages.dictionaries.PreliminaryCitedTitleListingPage;
import pages.dictionaries.VariantPreferredPage;
import pages.journalMaintenance.CreateNewJournalPage;
import pages.journalMaintenance.IssnPage;
import pages.journalMaintenance.ManageJournalsPage;
import pages.journalMaintenance.PublicationTransactionPage;

public abstract class MenuPage extends BasePage {
    //=== Main Menu Sections ===========================================================================================
    @FindBy(xpath = "[href='/jcr/html/main.html']")
    public Button homeMenu;

    @FindBy(xpath = ".//span[.='Dictionaries']")
    public Button DictionariesMainMenu;

    @FindBy(xpath = ".//span[.= 'Journal Maintenance']")
    public Button JournalMaintenanceMainMenu;

    @FindBy(xpath = ".//span[.= 'JCR Control']")
    public Button JCRControlMainMenu;

    @FindBy(css = "[href='/jcr/html/logout']")
    public Button logoffMainMenu;

    //=== Sub Menu Sections ============================================================================================
    @FindBy(css = "[href='/jcr/html/dictionaries/variant.html']")
    public Button VariantPreferredSubMenu;

    @FindBy(css = "[href='/jcr/html/homograph.html']")
    public Button HomographTableSubMenu;

    @FindBy(css = "[href='/jcr/html/dictionaries/citation.html']")
    public Button PreliminaryCitedTitleListingSubMenu;

    @FindBy(css = "[href='/jcr/html/word.html']")
    public Button FirstSecondWordSubMenu;

    @FindBy(css = "[href='/jcr/html/journals/journal.html']")
    public Button ManageJournalsSubMenu;

    @FindBy(css = "[href='/jcr/html/journals/journal.html?jen=true']")
    public Button CreateNewJournalSubMenu;

    @FindBy(css = "[href='/jcr/html/dictionaries/transaction.html']")
    public Button PublicationTransactionSubMenu;

    @FindBy(css = "[href='/jcr/html/issn.html']")
    public Button ISSNSubMenu;

    //=== Constructor ==================================================================================================
    public MenuPage() {
        super(false);
    }

    public MenuPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //=== Click methods ================================================================================================
    public MainPage clickHome() {
        return homeMenu.click()
                ? new MainPage()
                : null;
    }
    public VariantPreferredPage clickVariantPreferredSubMenu() {
        return DictionariesMainMenu.click() && VariantPreferredSubMenu.click()
                ? new VariantPreferredPage()
                : null;
    }
    public HomographTablePage clickHomographTableSubMenu() {
        return DictionariesMainMenu.click() && HomographTableSubMenu.click()
                ? new HomographTablePage()
                : null;
    }
    public PreliminaryCitedTitleListingPage clickPreliminaryCitedTitleListingSubMenu() {
        return DictionariesMainMenu.click() && PreliminaryCitedTitleListingSubMenu.click()
                ? new PreliminaryCitedTitleListingPage()
                : null;
    }
    public FirstSecondWordPage clickFirstSecondWordSubMenu() {
        return DictionariesMainMenu.click() && FirstSecondWordSubMenu.click()
                ? new FirstSecondWordPage()
                : null;
    }

    public ManageJournalsPage clickManageJournalsSubMenu() {
        return JournalMaintenanceMainMenu.click() && ManageJournalsSubMenu.click()
                ? new ManageJournalsPage()
                : null;
    }
    public CreateNewJournalPage clickCreateNewJournalSubMenu() {
        return JournalMaintenanceMainMenu.click() && CreateNewJournalSubMenu.click()
                ? new CreateNewJournalPage()
                : null;
    }
    public PublicationTransactionPage clickPublicationTransactionSubMenu() {
        return JournalMaintenanceMainMenu.click() && PublicationTransactionSubMenu.click()
                ? new PublicationTransactionPage()
                : null;
    }
    public IssnPage clickISSNSubMenu() {
        return JournalMaintenanceMainMenu.click() && ISSNSubMenu.click()
                ? new IssnPage()
                : null;
    }

}