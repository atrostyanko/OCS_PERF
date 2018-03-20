package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class ClaimRequestPage extends BaseIssuePage {
    @FindBy(name = "publseq")
    public TextInput journalSequence;

    //====== Constructor ==============================
    public ClaimRequestPage() {
        super(true);
    }
    public ClaimRequestPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Claiming");
        clickSubMenu("Claim Request");
        */
        String subURL = "Business/Issue/Claiming/ClaimRecord/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitBtn.isDisplayed()
                && journalSequence.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Claiming");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Claiming")
                    && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
        }
        return false;
    }

}
