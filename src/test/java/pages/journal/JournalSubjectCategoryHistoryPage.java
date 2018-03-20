package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalSubjectCategoryHistoryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalSubjectCategoryHistoryPage() {
        super(true);
    }
    public JournalSubjectCategoryHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Subject Category History");
        */
        String subURL = "Business/Journal/SubjectCatagoryHistory/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Subject Catagory History");
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
