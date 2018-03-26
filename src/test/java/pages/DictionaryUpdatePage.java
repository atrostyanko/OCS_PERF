package pages;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class DictionaryUpdatePage extends MenuPage {
    @FindBy(name = "printcb")
    public Button printcb;

    public DictionaryUpdatePage() {
        super(true);
    }

    public DictionaryUpdatePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        dictBtn.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.getDriver().getTitle().trim().equalsIgnoreCase("Dictionary Update Page")
                && printcb.isDisplayed();
    }

    //===== Click methods ==============================================================================================
}
