package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class EditingJournalRoyaltyPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditingJournalRoyaltyPage() {
        super(true);
    }
    public EditingJournalRoyaltyPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Royalty");
        clickSubMenu("Edit Royalty");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Editing Journal Royalty");
        }
        return false;
    }

    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }
}
