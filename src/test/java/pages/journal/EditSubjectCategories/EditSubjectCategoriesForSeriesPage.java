package pages.journal.EditSubjectCategories;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;
import pages.journal.MainJournalPage;

public class EditSubjectCategoriesForSeriesPage extends MainJournalPage {
    @FindBy (name = "addButton")
    public Button addButton;

    //====== Constructor ==============================
    public EditSubjectCategoriesForSeriesPage() {
        super(true);
    }
    public EditSubjectCategoriesForSeriesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit Subject Categories");
        clickSubMenu("For Series");
    }

    @Override
    public boolean isPageOpened() {
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