package pages.misc;

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
    public StatisticsByUserIdPage() {
        super(true);
    }

    public StatisticsByUserIdPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "UsersList.do";
            WebDriverFactory.navigateTo(subURL);
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
        return isPageOpened() && WebDriverFactory.isElementDisplayed(userDropDown) && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && WebDriverFactory.waitElementIsVisible(grid)
                && isPageOpened();
    }

    //===== Select methods =============================================================================================
    public boolean selectUser(String username) {
        return WebDriverFactory.selectByText(userDropDown, username);
    }
}
