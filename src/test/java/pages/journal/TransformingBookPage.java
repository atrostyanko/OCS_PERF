package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;

public class TransformingBookPage extends BaseJournalInquiryPage {
    @FindBy(name = "transformBook")
    public Button transformBookButton;

    @FindBy(name = "numberofFiles")
    public TextInput numberofFiles;

    //====== Constructor ==============================
    public TransformingBookPage() {
        super(true);
    }
    public TransformingBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Transform a Sample Book");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Transforming a Book");
        }
        return false;
    }

    //===== Click methods ==============================================================================================
    public IssueDetailsPage clickTransformButton() {
        return confirmButton.click()
                ? new IssueDetailsPage(false)
                : null;
    }
}
