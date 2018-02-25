package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;

public class AlterTitlesPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public AlterTitlesPage() {
        super(true);
    }
    public AlterTitlesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Alter Titles");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Alter Titles");
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
