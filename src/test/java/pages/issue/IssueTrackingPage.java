package pages.issue;

import com.webtestsbase.WebDriverFactory;

public class IssueTrackingPage extends BaseIssuePage {
    //====== Constructor ==============================
    public IssueTrackingPage() {
        super(true);
    }
    public IssueTrackingPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Issue Tracking");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Issue Tracking");
        }
        return false;
    }

}
