package pages.issue;

import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class MultipleIssueTrackingPage extends BaseIssuePage {
    @FindBy(name = "loginButton")
    public Button checkIn;

    @FindBy(name = "logoutButton")
    public Button checkOut;

    //====== Constructor ==============================
    public MultipleIssueTrackingPage() {
        super(true);
    }
    public MultipleIssueTrackingPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Multiple Issues Tracking");
    }

    @Override
    public boolean isSearchPageOpened() {
        return checkIn.isDisplayed()
                && checkOut.isDisplayed()
                && pageTitle.getText().equals("Multiple Issue Tracking");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Multiple Issue Tracking");
    }
}
