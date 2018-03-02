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
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Subscription History");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription History");
        }
        return false;
    }
}
