package pages;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = ".//span[contains(text(), 'CHEMICAL INFORMATION')]")
    private WebElement openIndicator;

    public MainPage() {
        super(false);
    }

    public MainPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(openIndicator);
    }

    //===== Click methods ==============================================================================================
}
