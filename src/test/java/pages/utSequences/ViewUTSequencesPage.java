package pages.utSequences;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public class ViewUTSequencesPage extends MainPage {
    @FindBy(name = "corrID")
    public TextInput corrId;

    @FindBy(xpath = "//td[contains(text(), 'Correction ID')]")
    private Label correctionIDColumn;

    @FindBy(css = "span.DataKey")
    public List<WebElement> fieldsList;

    //====== Constructor ==============================
    public ViewUTSequencesPage() {
        super(true);
    }

    public ViewUTSequencesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "ut/sequences/requests.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickUtSequencesMainMenu();
            clickSubMenu("View UT Sequences");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("View UT Sequences");
    }

    @Override
    public boolean isSearchPageOpened() {
        return pageTitle.getText().equals("View Requests With UT Sequences")
                && corrId.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        return submitBtn.click()
                && WebDriverFactory.waitAllElementsVisible(fieldsList)
                && isPageOpened();
    }

    //===== Check methods ==============================================================================================
}
