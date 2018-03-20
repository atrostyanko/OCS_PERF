package pages.journal.Delete;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.MainJournalPage;
import pages.publisher.BookInquiryPage;

public class DeleteSampleJournalPage extends MainJournalPage {
    @FindBy(name = "deleteButton")
    public Button deleteButton;

    //====== Constructor ==============================
    public DeleteSampleJournalPage() {
        super(true);
    }
    public DeleteSampleJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Delete");
        clickSubMenu("Delete Sample Journal");
        */
        String subURL = "Business/Journal/Edit/prompt_delete_sample_journal.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Deleting Sample Journal");
    }

    //===== Click methods ==============================================================================================
}
