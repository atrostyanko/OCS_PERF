package pages.login;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class CalendarLoginPage extends BasePage {
    @FindBy(name = "userid")
    public TextInput username;

    @FindBy(name = "password")
    public TextInput password;

    @FindBy(css = "input[value='LOG IN']")
    public Button loginBtn;

    public CalendarLoginPage() {
        super(true);
    }

    @Override
    public void openPage() {
        WebDriverFactory.navigateTo("/Calendar/");
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
