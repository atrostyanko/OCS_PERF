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
        /*
        clickIssue();
        clickSubMenu("Issue Tracking");
        */
        String subURL = "Business/Issue/Tracking/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Issue Tracking");
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Issue Tracking");
        }
        return false;
    }

}
