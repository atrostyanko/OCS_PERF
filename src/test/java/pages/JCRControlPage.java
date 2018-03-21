package pages;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JCRControlPage extends MenuPage {
    @FindBy(className = "jcrControlContent")
    private WebElement openIndicator;

    public JCRControlPage() {
        super(false);
    }

    public JCRControlPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        JCRControlMainMenu.click();
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
