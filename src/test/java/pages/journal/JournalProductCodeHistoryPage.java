package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class JournalProductCodeHistoryPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public JournalProductCodeHistoryPage() {
        super(true);
    }
    public JournalProductCodeHistoryPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Prod. Codes History");
        */
        String subURL = "Business/Journal/ProductCodeHistory/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Product Code History");
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Product Code History");
        }
        return false;
    }

    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

}
