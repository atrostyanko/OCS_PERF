package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class ClaimingActivePage extends BaseIssuePage {
    @FindBy(name = "publNo")
    public TextInput publNo;

    @FindBy(name = "journalSequenceNumber")
    public TextInput journalSequenceNumber;

    @FindBy(name = "submit")
    public Button submitChanges;

    //====== Constructor ==============================
    public ClaimingActivePage() {
        super(true);
    }
    public ClaimingActivePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Claiming");
        clickSubMenu("Active Claim");
        */
        String subURL = "Business/Issue/Claiming/ActiveClaim/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitBtn.isDisplayed()
                && publNo.isDisplayed()
                && journalSequenceNumber.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Claiming Active");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Claiming Active")
                    && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
        }
        return false;
    }

}
