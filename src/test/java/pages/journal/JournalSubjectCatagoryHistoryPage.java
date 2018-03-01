package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalSubjectCatagoryHistoryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalSubjectCatagoryHistoryPage() {
        super(true);
    }
    public JournalSubjectCatagoryHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Subject Category History");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Subject Catagory History");
        }
        return false;
    }

    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
