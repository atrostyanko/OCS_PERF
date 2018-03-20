package pages.journal.Subscriptions;

import com.webtestsbase.WebDriverFactory;
import pages.journal.BaseJournalInquiryPage;

public class JournalSubscriptionHistoryEditPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalSubscriptionHistoryEditPage() {
        super(true);
    }
    public JournalSubscriptionHistoryEditPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("View / Edit History");
        */
        String subURL = "Business/Journal/SubscriptionHistory/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription History");
        }
        return false;
    }

    public JournalSubscriptionDetailsPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalSubscriptionDetailsPage(false)
                : null;
    }
}
