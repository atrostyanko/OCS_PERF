package pages.journal.Delete;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.MainJournalPage;

public class DeleteSampleBookPage extends MainJournalPage {
    @FindBy(name = "deleteButton")
    public Button deleteButton;

    //====== Constructor ==============================
    public DeleteSampleBookPage() {
        super(true);
    }
    public DeleteSampleBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Delete");
        clickSubMenu("Delete Sample Book");
        */
        String subURL = "Business/Journal/Edit/prompt_delete_sample_book.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Sample Book");
    }

    //===== Click methods ==============================================================================================
}
