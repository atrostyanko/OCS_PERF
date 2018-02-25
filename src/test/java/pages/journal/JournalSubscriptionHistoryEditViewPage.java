package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalSubscriptionHistoryEditViewPage extends BaseJournalInquiryPage {
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
