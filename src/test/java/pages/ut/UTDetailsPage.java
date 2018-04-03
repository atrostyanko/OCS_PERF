package pages.ut;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public class UTDetailsPage extends MainPage {
    @FindBy(name = "corrID")
    public TextInput corrId;

    @FindBy(xpath = "//td[contains(text(), 'Correction ID')]")
    private Label correctionIDColumn;

    @FindBy(css = "span.DataKey")
    public List<WebElement> fieldsList;

    //====== Constructor ==============================
    public UTDetailsPage() {
        super(true);
    }

    public UTDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "ut/details/view.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickUTMainMenu();
            clickSubMenu("UT Details");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("UT Details");
    }

    @Override
    public boolean isSearchPageOpened() {
        return isPageOpened() && corrId.isDisplayed() && submitBtn.isDisplayed()
                && correctionIDColumn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && WebDriverFactory.waitAllElementsVisible(fieldsList);
    }

    //===== Check methods ==============================================================================================
}
