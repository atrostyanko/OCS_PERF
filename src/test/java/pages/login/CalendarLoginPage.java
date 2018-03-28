package pages.login;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class CalendarLoginPage extends BasePage {
    @FindBy(name = "userId")
    public TextInput username;

    @FindBy(name = "userPwd")
    public TextInput password;

    @FindBy(name = "LoginBtn")
    private Button LoginBtn;

    public CalendarLoginPage() {
        super(false);
    }

    @Override
    public void openPage() {
        WebDriverFactory.navigateTo(WebDriverFactory.getURL() + "/Calendar/");
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
