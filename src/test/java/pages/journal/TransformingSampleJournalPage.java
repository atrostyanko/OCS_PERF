package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;

public class TransformingSampleJournalPage extends BaseJournalInquiryPage {
    @FindBy(name = "title11")
    public TextInput title11Field;

    @FindBy(name = "title20")
    public TextInput title20Field;

    @FindBy(name = "title29")
    public TextInput title29Field;

    //====== Constructor ==============================
    public TransformingSampleJournalPage() {
        super(true);
    }
    public TransformingSampleJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Transform a Sample Journal");
    }

    @Override
    public boolean isPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Transforming a Sample Journal");
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
