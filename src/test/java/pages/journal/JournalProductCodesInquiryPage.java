package pages.journal;

public class JournalProductCodesInquiryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalProductCodesInquiryPage() {
        super(true);
    }
    public JournalProductCodesInquiryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Prod. Codes - Subj. Categories");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }
}
