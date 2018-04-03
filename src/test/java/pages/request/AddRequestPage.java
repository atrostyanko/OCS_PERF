package pages.request;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class AddRequestPage extends MainPage {
    @FindBy(css = "input[value = 'Add Request']")
    private Button addRequestButton;

    //====== Constructor ==============================
    public AddRequestPage() {
        super(true);
    }

    public AddRequestPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Request/Add/prompt.jsp";
            WebDriverFactory.navigateTo(subURL);
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
