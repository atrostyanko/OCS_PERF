package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditXRefNotesPage extends BaseJournalInquiryPage {
    @FindBy(name = "updateButton")
    public Button updateButton;

    @FindBy(name = "change[0].notes")
    public TextInput notes;

    @FindBy (xpath = ".//li[contains(text(), 'Notes information has been sucessfully updated.')]")
    public Label successfullyMessage;

    //====== Constructor ==============================
    public EditXRefNotesPage() {
        super(true);
    }
    public EditXRefNotesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit XRef Notes");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Edit XRef Notes");
        }
        return false;
    }

    public JournalChangesPage clickUpdateButton() {
        return updateButton.click()
                && WebDriverFactory.waitElementIsVisible(successfullyMessage.asWebElement())
                ? new JournalChangesPage(false)
                : null;
    }

}
