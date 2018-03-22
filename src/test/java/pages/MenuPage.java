package pages;

import com.google.errorprone.annotations.Var;
import com.utils.TimeUtils;
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
    @FindBy(css = "[href='/jcr/html/main.html']")
    public Button homeMenu;

    @FindBy(xpath = ".//span[.='Dictionaries']")
    public Button DictionariesMainMenu;

    @FindBy(xpath = ".//span[.= 'Journal Maintenance']")
    public Button JournalMaintenanceMainMenu;

    @FindBy(css = "[href='/jcr/html/jcrControl.html']")
    public Button JCRControlMainMenu;

    @FindBy(xpath = ".//span[.= 'Switch Collection']")
    public Button SwitchCollectionMainMenu;

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

    @FindBy(css = "[href='/jcr/html/main.html?to=wos']")
    public Button wosSubMenu;

    @FindBy(css = "[href='/jcr/html/main.html?to=scielo']")
    public Button scieloSubMenu;

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
        DictionariesMainMenu.mouseHoverJScript();
        return VariantPreferredSubMenu.click()
                ? new VariantPreferredPage()
                : null;
    }
    public HomographTablePage clickHomographTableSubMenu() {
        DictionariesMainMenu.mouseHoverJScript();
        return HomographTableSubMenu.click()
                ? new HomographTablePage()
                : null;
    }
    public PreliminaryCitedTitleListingPage clickPreliminaryCitedTitleListingSubMenu() {
        DictionariesMainMenu.mouseHoverJScript();
        return PreliminaryCitedTitleListingSubMenu.click()
                ? new PreliminaryCitedTitleListingPage()
                : null;
    }
    public FirstSecondWordPage clickFirstSecondWordSubMenu() {
        DictionariesMainMenu.mouseHoverJScript();
        return FirstSecondWordSubMenu.click()
                ? new FirstSecondWordPage()
                : null;
    }

    public ManageJournalsPage clickManageJournalsSubMenu() {
        JournalMaintenanceMainMenu.mouseHoverJScript();
        return ManageJournalsSubMenu.click()
                ? new ManageJournalsPage()
                : null;
    }
    public CreateNewJournalPage clickCreateNewJournalSubMenu() {
        JournalMaintenanceMainMenu.mouseHoverJScript();
        return CreateNewJournalSubMenu.click()
                ? new CreateNewJournalPage()
                : null;
    }
    public PublicationTransactionPage clickPublicationTransactionSubMenu() {
        JournalMaintenanceMainMenu.mouseHoverJScript();
        return PublicationTransactionSubMenu.click()
                ? new PublicationTransactionPage()
                : null;
    }
    public IssnPage clickISSNSubMenu() {
        JournalMaintenanceMainMenu.mouseHoverJScript();
        return ISSNSubMenu.click()
                ? new IssnPage()
                : null;
    }

    public JCRControlPage clickJCRControlMainMenu() {
        return JCRControlMainMenu.click()
                ? new JCRControlPage()
                : null;
    }

    public MainPage clickWOSSubMenu() {
        SwitchCollectionMainMenu.mouseHoverJScript();
        return wosSubMenu.click()
                ? new MainPage()
                : null;
    }
    public MainPage clickScieloSubMenu() {
        SwitchCollectionMainMenu.mouseHoverJScript();
        TimeUtils.waitForSeconds(1);
        return scieloSubMenu.click()
                ? new MainPage()
                : null;
    }

}