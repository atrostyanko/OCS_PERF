package pages.journal.Subscriptions;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.BaseJournalInquiryPage;

import java.util.List;

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
        /*
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("View History");
        */
        String subURL = "Business/Journal/SubscriptionHistory/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
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
}
