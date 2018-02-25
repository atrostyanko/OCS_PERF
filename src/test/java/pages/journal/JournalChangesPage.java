package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalChangesPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalChangesPage() {
        super(true);
    }
    public JournalChangesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal Changes");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Changes");
        }
        return false;
    }
}
