package pages.journal.Subscriptions;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import pages.journal.BaseJournalInquiryPage;

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
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ================================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subscription Details");
        }
        return false;
    }
}
