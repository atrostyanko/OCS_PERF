package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class EditSampleJournalPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditSampleJournalPage() {
        super(true);
    }
    public EditSampleJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Sample Journal");
        */
        String subURL = "Business/Journal/Edit/prompt_sample_journal_edit.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Sample Journal");
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
