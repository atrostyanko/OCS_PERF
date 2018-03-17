package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.support.FindBy;

public class EditJournalRoyaltyPage extends MainJournalPage {
    @FindBy(xpath = ".//span[contains(text(), 'Publisher Number')]")
    public Label publisherNumber;

    //====== Constructor ==============================
    public EditJournalRoyaltyPage() {
        super(true);
    }
    public EditJournalRoyaltyPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Royalty");
        clickSubMenu("Edit Royalty");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Editing Journal Royalty");
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Editing Journal Royalty");
        }
        return false;
    }

    public JournalRoyaltyInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalRoyaltyInquiryPage(false)
                : null;
    }
}
