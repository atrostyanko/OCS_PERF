package pages.login;

import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class LoginPage extends BasePage {
    @FindBy(name = "userId")
    public TextInput username;

    @FindBy(name = "userPwd")
    public TextInput password;

    @FindBy(name = "LoginBtn")
    private Button LoginBtn;

    public LoginPage() {
        super(false);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return username.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public MainPage submit() {
        return this.LoginBtn.click()
                ? new MainPage()
                : null;
    }
}
