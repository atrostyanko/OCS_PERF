package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class RoyaltyInquiryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public RoyaltyInquiryPage() {
        super(true);
    }
    public RoyaltyInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Royalty");
        clickSubMenu("Royalty Inquiry§");
    }

    @Override
    public boolean isPageOpened() {
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
