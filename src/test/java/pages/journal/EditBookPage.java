package pages.journal;

import pages.publisher.BookInquiryPage;

public class EditBookPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditBookPage() {
        super(true);
    }
    public EditBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Book");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public BookInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new BookInquiryPage(false)
                : null;
    }

}
