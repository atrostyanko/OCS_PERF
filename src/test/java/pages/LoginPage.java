package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "username")
    private TextInput userID;

    @FindBy(name = "password")
    private TextInput password;

    @FindBy(name = "submit")
    private Button submit;

    public LoginPage() {
        super(false);
    }

    public LoginPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return userID.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setPassword(String password) {
        return this.password.setText(password);
    }

    public boolean setUserID(String userID) {
        return this.userID.setText(userID);
    }

    public MainPage submit() {
        return this.submit.click()
                ? new MainPage()
                : null;
    }
}
