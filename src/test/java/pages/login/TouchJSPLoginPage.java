package pages.login;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class TouchJSPLoginPage extends BasePage {
    @FindBy(name = "j_username")
    public TextInput username;

    @FindBy(name = "j_password")
    public TextInput password;

    @FindBy(css = "input[value='Login']")
    public Button loginBtn;

    public TouchJSPLoginPage() {
        super(true);
    }

    @Override
    public void openPage() {
        WebDriverFactory.navigateTo("/touchJSP");
    }

    @Override
    public boolean isPageOpened() {
        return username.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    /*
    public boolean submit() {
        return this.loginBtn.click();
    }
    */
}
