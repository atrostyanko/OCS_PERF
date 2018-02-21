package pages.journal;

public class EditSampleBookPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditSampleBookPage() {
        super(true);
    }
    public EditSampleBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Sample Book");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
