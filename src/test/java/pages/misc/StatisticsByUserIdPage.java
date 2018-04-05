package pages.misc;

import com.reporting.ExtentManager;
import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class StatisticsByUserIdPage extends MainPage {
    @FindBy(name = "userId")
    public WebElement userDropDown;

    @FindBy(id = "Gridid")
    public WebElement grid;

    //====== Constructor ==============================
    public StatisticsByUserIdPage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super(webDriverFactory, extentManager, true);
    }

    public StatisticsByUserIdPage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu) {
        super(webDriverFactory, extentManager, openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "UsersList.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Statistics");
            clickSubMenu("By User Id");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Statistics By User Id");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && webDriverFactory.isElementDisplayed(userDropDown) && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && webDriverFactory.waitElementIsVisible(grid)
                && isPageOpened();
    }

    //===== Select methods =============================================================================================
    public boolean selectUser(String username) {
        return webDriverFactory.selectByText(userDropDown, username);
    }
}
