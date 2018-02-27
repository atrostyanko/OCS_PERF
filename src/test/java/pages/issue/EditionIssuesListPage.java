package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditionIssuesListPage extends BaseIssuePage {
    @FindBy(name = "product")
    private WebElement product;

    @FindBy(css = "input[src *='submit_button.gif']")
    private Button submitBtn;

    //====== Constructor ==============================
    public EditionIssuesListPage() {
        super(true);
    }
    public EditionIssuesListPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Issue Hold");
    }

    @Override
    public boolean isPageOpened() {
        return WebDriverFactory.isElementDisplayed(product) && submitBtn.isDisplayed();
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Edition Issues List")
                    && WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
        }
        return false;
    }

    //===== Select methods =============================================================================================
    public boolean selectProduct(String sProductValue) {
        return WebDriverFactory.selectByValue(product, sProductValue);
    }

}
