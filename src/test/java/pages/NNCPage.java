package pages;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class NNCPage extends MenuPage {
    @FindBy(name = "newBtn")
    public Button newBtn;

    @FindBy(name = "retrieveBtn")
    public Button retrieveBtn;

    public NNCPage() {
        super(true);
    }

    public NNCPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        nncBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("NNC Journal Input")
                && retrieveBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
}
