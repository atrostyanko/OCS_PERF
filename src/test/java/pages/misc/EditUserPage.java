package pages.misc;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class EditUserPage extends MainPage {
    @FindBy(name = "userNo")
    public WebElement userDropDown;

    @FindBy(css = "input[value='Update User']")
    public Button updateUserButton;

    //====== Constructor ==============================
    public EditUserPage() {
        super(true);
    }

    public EditUserPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "UsersListForEdit.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickMiscMainMenu();
            clickSubMenu("Admin");
            clickSubMenu("Edit User");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Edit User");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && WebDriverFactory.isElementDisplayed(userDropDown) && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && WebDriverFactory.waitElementIsVisible(updateUserButton.asWebElement())
                && isPageOpened();
    }

    //===== Select methods =============================================================================================
    public boolean selectUser(String username) {
        return WebDriverFactory.selectByText(userDropDown, username);
    }
}
