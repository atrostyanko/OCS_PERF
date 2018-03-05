package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.journal.Subscriptions.JournalSubscriptionHistoryPage;

public class BaseJournalInquiryPage extends MainJournalPage {
    @FindBy (css = "a.NavBarLinks[href *= 'JournalInquiry.do?']")
    @CacheLookup
    public Button JournalInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalIssuesList.do?']")
    @CacheLookup
    public Button JournalIssuesListTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalChanges.do?']")
    @CacheLookup
    public Button JournalChangesTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalProductCodes.do?']")
    @CacheLookup
    public Button JournalProductCodesTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalProductCodeHistory.do?']")
    @CacheLookup
    public Button JournalProductCodeHistoryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalSubjectCatagoryHistory.do?']")
    @CacheLookup
    public Button JournalSubjectCatagoryHistoryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalRoyaltyInquiry.do?']")
    @CacheLookup
    public Button JournalRoyaltyInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'JournalSubscriptionHistory.do?']")
    @CacheLookup
    public Button JournalSubscriptionHistoryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'RetrieveJournalForAddingIssueAction.do?']")
    @CacheLookup
    public Button RetrieveJournalForAddingIssueActionTab;

    //====== Constructor ==============================
    public BaseJournalInquiryPage() {
        super(true);
    }
    public BaseJournalInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickJrnlInqTab() {
        return JournalInquiryTab.click()
                ? new JournalInquiryPage(false)
                : null;
    }
    public JournalIssuesListPage clickCDRXTab() {
        return JournalIssuesListTab.click()
                ? new JournalIssuesListPage(false)
                : null;
    }
    public JournalChangesPage clickJrnlXRefTab() {
        return JournalChangesTab.click()
                ? new JournalChangesPage(false)
                : null;
    }
    public JournalProductCodesInquiryPage clickPCSCTab() {
        return JournalProductCodesTab.click()
                ? new JournalProductCodesInquiryPage(false)
                : null;
    }
    public JournalProductCodeHistoryPage clickPCHistTab() {
        return JournalProductCodeHistoryTab.click()
                ? new JournalProductCodeHistoryPage(false)
                : null;
    }
    public JournalSubjectCategoryHistoryPage clickSCHistTab() {
        return JournalSubjectCatagoryHistoryTab.click()
                ? new JournalSubjectCategoryHistoryPage(false)
                : null;
    }
    public JournalRoyaltyInquiryPage clickRoyInqTab() {
        return JournalRoyaltyInquiryTab.click()
                ? new JournalRoyaltyInquiryPage(false)
                : null;
    }
    public JournalSubscriptionHistoryPage clickSubsHistTab() {
        return JournalSubscriptionHistoryTab.click()
                ? new JournalSubscriptionHistoryPage(false)
                : null;
    }
    public JournalIssueLoginPage clickIssueLoginTab() {
        return RetrieveJournalForAddingIssueActionTab.click()
                ? new JournalIssueLoginPage(false)
                : null;
    }

    //===== Get methods ================================================================================================
    public boolean isMessageDisplayed(String message) {
        return WebDriverFactory.waitAndFindDisplayedElement(By.xpath(".//li[contains(text(), '" + message + "')]")) != null;
    }
}
