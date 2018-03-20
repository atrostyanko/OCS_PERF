package pages.journal;

import com.webtestsbase.WebDriverFactory;

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
        /*
        clickJournal();
        clickSubMenu("Prod. Codes - Subj. Categories");
        */
        String subURL = "Business/Journal/ProductCodes/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Journal Product Codes Inquiry");
    }
}
