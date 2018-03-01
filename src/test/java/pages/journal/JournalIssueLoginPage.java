package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.issue.IssueDetailsPage;

public class JournalIssueLoginPage extends BaseJournalInquiryPage {
    @FindBy(name = "media")
    public WebElement mediaDropDown;

    @FindBy(name = "pubYearRange")
    public TextInput pubYearRange;

    //====== Constructor ==============================
    public JournalIssueLoginPage() {
        super(true);
    }
    public JournalIssueLoginPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickJournal();
        clickSubMenu("Issue Login");
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Issue Login for a Journal");
        }
        return false;
    }

    //===== Select methods =============================================================================================
    public boolean selectMedia(String sMedia) {
        return WebDriverFactory.selectByValue(mediaDropDown, sMedia);
    }

    //===== Click methods ==============================================================================================
    public IssueDetailsPage clickConfirmButton() {
        return confirmButton.click()
                ? new IssueDetailsPage(false)
                : null;
    }
}
