package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalSubscriptionHistoryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalSubscriptionHistoryPage() {
        super(true);
    }
    public JournalSubscriptionHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("View History");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription History");
        }
        return false;
    }
}
