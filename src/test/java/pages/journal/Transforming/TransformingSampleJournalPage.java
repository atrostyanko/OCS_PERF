package pages.journal.Transforming;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;
import pages.journal.BaseJournalInquiryPage;

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
        /*
        clickJournal();
        clickSubMenu("Transform a Sample Journal");
        */
        String subURL = "Business/Journal/Edit/prompt_sample_journal_transform.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Transforming a Sample Journal");
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
