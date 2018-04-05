package pages.misc;

import com.reporting.ExtentManager;
import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class StatisticsByRequestStatusPage extends MainPage {
    @FindBy(css = "input[name='statusType'][value='I']")
    public CheckBox requestsWithStatus_I;

    @FindBy(id = "Gridid")
    public WebElement grid;

    //====== Constructor ==============================
    public StatisticsByRequestStatusPage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super(webDriverFactory, extentManager, true);
    }

    public StatisticsByRequestStatusPage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu) {
        super(webDriverFactory, extentManager, openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Misc/Statistics/ByStatus/prompt.jsp";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Statistics");
            clickSubMenu("By Status");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Statistics By Request Status");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && requestsWithStatus_I.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && webDriverFactory.waitElementIsVisible(grid)
                && isPageOpened();
    }

    //===== Check methods ==============================================================================================
}
