package pages.journal;

import com.webtestsbase.WebDriverFactory;

public class VariantsPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public VariantsPage() {
        super(true);
    }
    public VariantsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Add Variants");
        */
        String subURL = "Business/Journal/Transform/Variants/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Variants");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Variants");
        }
        return false;
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }
}
