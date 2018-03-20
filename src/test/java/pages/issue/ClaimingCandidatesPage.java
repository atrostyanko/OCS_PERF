package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

import java.lang.management.BufferPoolMXBean;

public class ClaimingCandidatesPage extends BaseIssuePage {
    @FindBy(name = "publisherCode")
    public TextInput publisherCode;

    @FindBy(name = "submit")
    public Button submitChanges;

    //====== Constructor ==============================
    public ClaimingCandidatesPage() {
        super(true);
    }
    public ClaimingCandidatesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickIssue();
        clickSubMenu("Claiming");
        clickSubMenu("Candidates");
        */
        String subURL = "Business/Issue/Claiming/Candidate/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return submitBtn.isDisplayed()
                && publisherCode.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Claiming Candidates");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Claiming Candidates")
                    && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
        }
        return false;
    }

}
