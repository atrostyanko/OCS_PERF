package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PublisherInquiryPage extends MainPublisherPage {
    @FindBy (xpath = ".//span[.= 'Summary Counts of Journals']")
    private WebElement summaryCounts;

    @FindBy (xpath = ".//span[contains(text(), 'Royalty Remarks')]")
    private WebElement royaltyRemarks;

    @FindBy (xpath = ".//span[contains(text(), 'Publisher Notes')]")
    private WebElement publisherNotes;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherInquiry.do?']")
    @CacheLookup
    public Button publisherInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalList.do?']")
    @CacheLookup
    public Button journalListTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherRoyaltyInquiry.do?']")
    @CacheLookup
    public Button royaltyInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalsRoyalty.do?']")
    @CacheLookup
    public Button journalsRoyaltyList;

    //====== Constructor ==============================
    public PublisherInquiryPage() {
        super(true);
    }
    public PublisherInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Publisher Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return publisherKey.isDisplayed() && Journal.isDisplayed() && Book.isDisplayed();
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
