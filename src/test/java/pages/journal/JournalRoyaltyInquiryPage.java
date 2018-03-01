package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalRoyaltyInquiryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalRoyaltyInquiryPage() {
        super(true);
    }
    public JournalRoyaltyInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Royalty");
        clickSubMenu("Royalty Inquiry");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Royalty Inquiry");
        }
        return false;
    }
}
