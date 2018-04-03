package pages.request;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class RequestDetailsPage extends MainPage {
    @FindBy(name = "corrId")
    public TextInput corrId;

    @FindBy(css = "nobr.DataKey")
    public List<WebElement> fieldsList;

    //====== Constructor ==============================
    public RequestDetailsPage() {
        super(true);
    }

    public RequestDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "Business/Request/Details/prompt.jsp";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickRequestMainMenu();
            clickSubMenu("Request Details");
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
                && WebDriverFactory.waitAllElementsVisible(fieldsList);
    }

    //===== Check methods ==============================================================================================
}
