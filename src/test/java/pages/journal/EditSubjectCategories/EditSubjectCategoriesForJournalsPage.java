package pages.journal.EditSubjectCategories;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

public class EditSubjectCategoriesForJournalsPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    //====== Constructor ==============================
    public EditSubjectCategoriesForJournalsPage() {
        super(true);
    }
    public EditSubjectCategoriesForJournalsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Subject Categories");
        clickSubMenu("For Journals");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

    public boolean clickConfirmAddingSubjectCategoriesButton() {
        return confirmButton.click() && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
    }

    public boolean clickAddProductCodesButton() {
        return addButton.click() && WebDriverFactory.waitElementIsVisible(confirmButton.asWebElement());
    }
}
