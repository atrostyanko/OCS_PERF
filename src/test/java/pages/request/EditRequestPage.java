package pages.request;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public class EditRequestPage extends MainPage {
    @FindBy(name = "corrId")
    public TextInput corrId;

    @FindBy(css = "input[value = 'Save Request']")
    private Button saveRequestButton;

    //====== Constructor ==============================
    public EditRequestPage() {
        super(true);
    }

    public EditRequestPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Request/Edit/prompt.jsp";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickRequestMainMenu();
            clickSubMenu("Edit Request");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Request");
    }

    @Override
    public boolean isSearchPageOpened() {
        return corrId.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && WebDriverFactory.waitElementIsVisible(saveRequestButton.asWebElement());
    }

    //===== Check methods ==============================================================================================
}
