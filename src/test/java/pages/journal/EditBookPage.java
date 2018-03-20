package pages.journal;

import com.webtestsbase.WebDriverFactory;
import pages.publisher.BookInquiryPage;

public class EditBookPage extends MainJournalPage {
    //====== Constructor ==============================
    public EditBookPage() {
        super(true);
    }
    public EditBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Book");
        */
        String subURL = "Business/Journal/Edit/prompt_book.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Book");
    }

    //===== Click methods ==============================================================================================
    public BookInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new BookInquiryPage(false)
                : null;
    }

}
