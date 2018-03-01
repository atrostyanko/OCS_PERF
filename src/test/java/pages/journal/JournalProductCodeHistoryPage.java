package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalProductCodeHistoryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalProductCodeHistoryPage() {
        super(true);
    }
    public JournalProductCodeHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Prod. Codes History");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Product Code History");
        }
        return false;
    }

    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
