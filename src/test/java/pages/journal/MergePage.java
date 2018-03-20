package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class MergePage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public MergePage() {
        super(true);
    }
    public MergePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Merge");
        */
        String subURL = "Business/Journal/Transform/Merge/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Merge");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Merge");
        }
        return false;
    }

    //===== Click methods ==============================================================================================
    public JournalChangesPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalChangesPage(false)
                : null;
    }
}
