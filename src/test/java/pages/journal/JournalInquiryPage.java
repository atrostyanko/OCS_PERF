package pages.journal;

public class JournalInquiryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalInquiryPage() {
        super(true);
    }
    public JournalInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal Inquiry");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }
}
