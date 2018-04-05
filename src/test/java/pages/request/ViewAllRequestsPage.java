package pages.request;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class ViewAllRequestsPage extends MainPage {
    @FindBy(css = "input[name='requestType'][value='ALL']")
    public CheckBox viewAllRequestsCheckBox;

    @FindBy(id = "Gridid")
    public WebElement requestsGrid;

    //====== Constructor ==============================
    public ViewAllRequestsPage() {
        super(true);
    }

    public ViewAllRequestsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "ViewAllRequestsPrompt.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickRequestMainMenu();
            clickSubMenu("View All Requests");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Request Details");
    }

    @Override
    public boolean isSearchPageOpened() {
        return viewAllRequestsCheckBox.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && webDriverFactory.waitElementIsVisible(requestsGrid);
    }

    //===== Check methods ==============================================================================================
}
