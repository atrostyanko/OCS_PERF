package pages.reports;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class BaseReportsPage extends MainPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public Label pageTitle;

    @FindBy(name = "periodicity")
    private WebElement periodicity;

    @FindBy(css = "input[src *='submit_button.gif']")
    public Button submitBtn;

    //====== Constructor ==============================
    public BaseReportsPage() {
        super(true);
    }

    public BaseReportsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isSearchPageOpened() {
        return WebDriverFactory.isElementDisplayed(periodicity) && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    @Override
    public boolean clickSubmit() {
        return submitBtn.click();
    }
}
