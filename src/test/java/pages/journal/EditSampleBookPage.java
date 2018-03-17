package pages.journal;

import pages.publisher.BookInquiryPage;

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
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Sample Book");
    }

    //===== Click methods ==============================================================================================
    public BookInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new BookInquiryPage(false)
                : null;
    }

}
