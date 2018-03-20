package pages.journal.Subscriptions;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
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
        /*
        clickJournal();
        clickSubMenu("Subscriptions");
        clickSubMenu("Subscription Details");
        */
        String subURL = "Business/Journal/SubscriptionDetails/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Subscription Details");
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
