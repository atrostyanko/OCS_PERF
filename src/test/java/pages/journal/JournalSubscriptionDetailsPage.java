package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalSubscriptionDetailsPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalSubscriptionDetailsPage() {
        super(true);
    }
    public JournalSubscriptionDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("Subscription Details");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription Details");
        }
        return false;
    }

}
