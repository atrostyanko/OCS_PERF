package pages.request;

import com.reporting.ExtentManager;
import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class AddRequestPage extends MainPage {
    @FindBy(css = "input[value = 'Add Request']")
    private Button addRequestButton;

    //====== Constructor ==============================
    public AddRequestPage(WebDriverFactory webDriverFactory, ExtentManager eReport) {
        super(webDriverFactory, eReport, true);
    }

    public AddRequestPage(WebDriverFactory webDriverFactory, ExtentManager eReport, boolean openFromMenu) {
        super(webDriverFactory, eReport, openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Request/Add/prompt.jsp";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickRequestMainMenu();
            clickSubMenu("Add Request");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Request")
                && addRequestButton.isDisplayed();
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }

    //===== Click methods ==============================================================================================

    //===== Check methods ==============================================================================================
}
