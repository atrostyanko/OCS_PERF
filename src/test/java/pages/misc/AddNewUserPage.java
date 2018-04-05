package pages.misc;

import com.reporting.ExtentManager;
import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class AddNewUserPage extends MainPage {
    @FindBy(css = "input[value='Save User']")
    public Button saveUserButton;

    //====== Constructor ==============================
    public AddNewUserPage(WebDriverFactory webDriverFactory, ExtentManager extentManager) {
        super(webDriverFactory, extentManager, true);
    }

    public AddNewUserPage(WebDriverFactory webDriverFactory, ExtentManager extentManager, boolean openFromMenu) {
        super(webDriverFactory, extentManager, openFromMenu);
    }

    @Override
    public void openPage() {
        if (webDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "AddUserPrompt.do";
            webDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Admin");
            clickSubMenu("Add User");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Add New User")
                && saveUserButton.isDisplayed();
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened();
    }
}
