package pages.request;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class RequestsReadyForReleasePage extends MainPage {
    @FindBy(id = "Gridid")
    private WebElement requestGrid;

    //====== Constructor ==============================
    public RequestsReadyForReleasePage() {
        super(true);
    }

    public RequestsReadyForReleasePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "RequestsForRelease.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickRequestMainMenu();
            clickSubMenu("Requests Ready For Release");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Request Details")
                && requestGrid.isDisplayed();
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }

    //===== Click methods ==============================================================================================

    //===== Check methods ==============================================================================================
}
