package pages.utSequences;

import com.webtestsbase.Browser;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public class ViewDeleteUTSequencesPage extends MainPage {
    @FindBy(name = "corrID")
    public TextInput corrId;

    @FindBy(xpath = "//td[contains(text(), 'Correction ID')]")
    private Label correctionIDColumn;

    @FindBy(css = "span.DataKey")
    public List<WebElement> fieldsList;

    //====== Constructor ==============================
    public ViewDeleteUTSequencesPage() {
        super(true);
    }

    public ViewDeleteUTSequencesPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        if (WebDriverFactory.getBrowser() == Browser.PHANTOMJS) {
            String subURL = "ut/sequences/delete/requests.do";
            WebDriverFactory.navigateTo(subURL);
        } else {
            clickUtSequencesMainMenu();
            clickSubMenu("View/Delete UT Sequences");
        }
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("View/Delete UT Sequences");
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
