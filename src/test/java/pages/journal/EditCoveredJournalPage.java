package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class EditCoveredJournalPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditCoveredJournalPage() {
        super(true);
    }
    public EditCoveredJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Covered Journal");
        */
        String subURL = "Business/Journal/Edit/prompt_covered_journal_edit.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Covered Journal");
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
