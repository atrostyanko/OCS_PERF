package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "uName")
    public TextInput username;

    @FindBy(id = "uPwd")
    public TextInput password;

    @FindBy(css = "[type='submit']")
    private Button submit;

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
        return this.submit.click()
                ? new MainPage()
                : null;
    }
}
