package pages.journal;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickJournal();
        clickSubMenu("Journal Inquiry");
        */
        String subURL = "Business/Journal/Inquiry/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Inquiry");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Inquiry");
        }
        return false;
    }
}
