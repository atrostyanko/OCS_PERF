package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JournalChangesPage extends BaseJournalInquiryPage {
    @FindBy(xpath = ".//span[contains(text(), 'Notes')]")
    public Label actionPerformedNotes;

    //====== Constructor ==============================
    public JournalChangesPage() {
        super(true);
    }
    public JournalChangesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Journal Changes");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Journal Changes");
        }
        return false;
    }

    //===== Get methods ================================================================================================
    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }
}
