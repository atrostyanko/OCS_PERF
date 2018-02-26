package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import org.openqa.selenium.support.FindBy;

public class DropSuspendCeasePage extends BaseJournalInquiryPage {
    @FindBy(css = "input[value = 'suspend']")
    public CheckBox suspendOption;

    @FindBy(css = "input[value = 'reactivate']")
    public CheckBox reactivateOption;

    //====== Constructor ==============================
    public DropSuspendCeasePage() {
        super(true);
    }
    public DropSuspendCeasePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Drop/Cease/Suspend");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Drop Suspend Cease");
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
