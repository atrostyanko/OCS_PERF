package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import org.openqa.selenium.support.FindBy;

public class AbsorbPage extends BaseJournalInquiryPage {
    //====== Constructor ==============================
    public AbsorbPage() {
        super(true);
    }
    public AbsorbPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Absorb");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Absorb");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Absorb");
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
