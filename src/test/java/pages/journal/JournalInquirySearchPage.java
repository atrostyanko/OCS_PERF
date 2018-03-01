package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalInquirySearchPage extends BaseJournalInquiryPage {

    //====== Constructor ==============================
    public JournalInquirySearchPage() {
        super(true);
    }
    public JournalInquirySearchPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal Inquiry");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Inquiry");
        }
        return false;
    }
}
