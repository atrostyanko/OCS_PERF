package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class PublisherInquiryPage extends MainPage {
    @FindBy(name = "publisherKey")
    @CacheLookup
    private TextInput publisherKey;

    @FindBy(css = "input[name='publisherKeyType'][value='J']")
    @CacheLookup
    private CheckBox Journal;

    @FindBy(css = "input[name='publisherKeyType'][value='B']")
    @CacheLookup
    private CheckBox Book;

    @FindBy (xpath = ".//span[contains(text(), 'Publisher Number')]")
    @CacheLookup
    private WebElement publisherNumber;

    @FindBy (xpath = ".//span[.= 'Summary Counts of Journals']")
    @CacheLookup
    private WebElement summaryCounts;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherInquiry.do?']")
    @CacheLookup
    private Button publisherInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalList.do?']")
    @CacheLookup
    private Button JournalListTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherRoyaltyInquiry.do?']")
    @CacheLookup
    private Button royaltyInquiryTab;

    @FindBy (css = "a.NavBarLinks[href *= 'PublisherJournalsRoyalty.do?']")
    @CacheLookup
    private Button JournalsRoyaltyList;

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
        clickPublisherSubMenu("Publisher Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return publisherKey.isDisplayed() && Journal.isDisplayed() && Book.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setPublisherKey(String sValue) {
        return publisherKey.setText(sValue);
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(publisherNumber);
        }
        return false;
    }
    public boolean clickJournalListTab() {
        if (JournalListTab.click()) {
            return WebDriverFactory.waitElementIsVisible(summaryCounts);
        }
        return false;
    }
}
