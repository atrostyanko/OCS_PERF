package pages.journal;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class TitleChangesPage extends BaseJournalInquiryPage {
    @FindBy(name = "acusitionUser")
    public TextInput acusitionUser;

    //====== Constructor ==============================
    public TitleChangesPage() {
        super(true);
    }
    public TitleChangesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickJournal();
        clickSubMenu("Journal XRef");
        clickSubMenu("Title Changes");
        */
        String subURL = "Business/Journal/Transform/TitleChanges/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return journalSequenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Title Changes");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Title Changes");
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
