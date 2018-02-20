package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PublisherJournalListPage extends MainPublisherPage {
    @FindBy(css = "a.NavBarLinks[href *= 'PublisherInquiry.do?']")
    @CacheLookup
    private Button publisherInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalList.do?']")
    @CacheLookup
    private Button journalListTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherRoyaltyInquiry.do?']")
    @CacheLookup
    private Button royaltyInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalsRoyalty.do?']")
    @CacheLookup
    private Button journalsRoyaltyList;

    @FindBy (xpath = ".//span[.= 'Summary Counts of Journals']")
    private WebElement summaryCounts;

    @FindBy (xpath = ".//span[contains(text(), 'Royalty Remarks')]")
    private WebElement royaltyRemarks;

    @FindBy (xpath = ".//span[contains(text(), 'Publisher Notes')]")
    private WebElement publisherNotes;

    //====== Constructor ==============================
    public PublisherJournalListPage() {
        super(true);
    }

    public PublisherJournalListPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("List of Journals");
    }

    @Override
    public boolean isPageOpened() {
        return publisherKey.isDisplayed() && journal.isDisplayed() && book.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickJournalListTab() {
        if (journalListTab.click()) {
            return WebDriverFactory.waitElementIsVisible(summaryCounts);
        }
        return false;
    }
    public boolean clickRoyaltyInquiryTab() {
        if (royaltyInquiryTab.click()) {
            return WebDriverFactory.waitElementIsVisible(royaltyRemarks);
        }
        return false;
    }
    public boolean clickJournalsRoyaltyList() {
        if (journalsRoyaltyList.click()) {
            return WebDriverFactory.waitElementIsVisible(royaltyRemarks);
        }
        return false;
    }
    public boolean clickPublisherInquiryTab() {
        if (publisherInquiryTab.click()) {
            return WebDriverFactory.waitElementIsVisible(publisherNotes);
        }
        return false;
    }

}
