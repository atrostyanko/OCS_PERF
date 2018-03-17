package pages.journal.Subscriptions;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.BaseJournalInquiryPage;

import java.util.List;

public class JournalSubscriptionHistoryEditViewPage extends BaseJournalInquiryPage {
    @FindBy(xpath = ".//a[contains(@href, 'EDIT_SUBSCRIPTION_DETAILS')]")
    private List<WebElement> editButtonList;

    @FindBy(xpath = ".//a[contains(@href, 'subscriptionSequenceNumber=')]")
    private List<WebElement> seqNoList;

    //====== Constructor ==============================
    public JournalSubscriptionHistoryEditViewPage() {
        super(true);
    }
    public JournalSubscriptionHistoryEditViewPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("View / Edit History");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Subscription History");
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription History");
        }
        return false;
    }

    public JournalSubscriptionHistoryEditPage clickEditButton(String seqNo) {
        if (seqNoList != null) {
            WebElement webElement = WebDriverFactory.getElementWithMatchingText(seqNoList, seqNo);
            if (webElement != null) {
                WebElement parent = WebDriverFactory.getParentUntilTagName(webElement, "tr");
                WebElement child = WebDriverFactory.getChildElement(parent, By.xpath("//a[contains(@href, 'EDIT_SUBSCRIPTION_DETAILS')]"));
                if (child != null && WebDriverFactory.clickElement(child)) {
                    return new JournalSubscriptionHistoryEditPage(false);
                }
            }
        }
        return null;
    }
}
