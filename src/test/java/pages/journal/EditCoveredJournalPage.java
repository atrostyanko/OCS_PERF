package pages.journal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCoveredJournalPage extends MainJournalPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    //====== Constructor ==============================
    public EditCoveredJournalPage() {
        super(true);
    }
    public EditCoveredJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Edit");
        clickSubMenu("Edit Covered Journal");
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

}
