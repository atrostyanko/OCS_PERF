package pages.issue;

import com.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueProductExtractionDetailsPage extends BaseIssuePage {
    @FindBy(name = "isiProductCode")
    private WebElement isiProductCode;

    //====== Constructor ==============================
    public IssueProductExtractionDetailsPage() {
        super(true);
    }
    public IssueProductExtractionDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Extraction Details");
    }

    @Override
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitTextToBePresentInElement(pageTitle, "Issue Product Extraction Details");
        }
        return false;
    }

    //===== Select methods =============================================================================================
    public boolean selectISIProdCode(String sISIProdCode) {
        return WebDriverFactory.selectByValue(isiProductCode, sISIProdCode);
    }
}
