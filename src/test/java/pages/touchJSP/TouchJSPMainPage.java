package pages.touchJSP;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.login.TouchJSPLoginPage;

public class TouchJSPMainPage extends BasePage {
    @FindBy (id = "issueNo")
    public TextInput issueNo;

    @FindBy (name = "search")
    public Button searchButton;

    @FindBy(name = "logout")
    private Button logoffButton;

    public TouchJSPMainPage() {
        super(false);
    }

    public TouchJSPMainPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return issueNo.isDisplayed() && searchButton.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public TouchJSPLoginPage logout() {
        return logoffButton.click()
                ? new TouchJSPLoginPage()
                : null;
    }
}
