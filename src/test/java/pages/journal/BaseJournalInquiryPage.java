package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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

    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    //====== Constructor ==============================
    public BaseJournalInquiryPage() {
        super(true);
    }
    public BaseJournalInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //===== Click methods ==============================================================================================
    public boolean clickJrnlInqTab() {
        if (JournalInquiryTab.click()) {
            return WebDriverFactory.waitElementIsVisible(jrnlBookSeq);
        }
        return false;
    }
    public boolean clickCDRXTab() {
        if (JournalIssuesListTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Issues List");
        }
        return false;
    }
    public boolean clickJrnlXRefTab() {
        if (JournalChangesTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Changes");
        }
        return false;
    }
    public boolean clickPCSCTab() {
        if (JournalProductCodesTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Product Codes Inquiry");
        }
        return false;
    }
    public boolean clickPCHistTab() {
        if (JournalProductCodeHistoryTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Product Code History");
        }
        return false;
    }
    public boolean clickSCHistTab() {
        if (JournalSubjectCatagoryHistoryTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subject Catagory History");
        }
        return false;
    }
    public boolean clickRoyInqTab() {
        if (JournalRoyaltyInquiryTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Royalty Inquiry");
        }
        return false;
    }
    public boolean clickSubsHistTab() {
        if (JournalSubscriptionHistoryTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription History");
        }
        return false;
    }
    public boolean clickIssueLoginTab() {
        if (RetrieveJournalForAddingIssueActionTab.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Issue Login for a Journal");
        }
        return false;
    }
}
