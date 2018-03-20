package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueProductExtractionDetailsPage extends BaseIssuePage {
    @FindBy(xpath = ".//span[contains(text(), 'DF Issueno')]")
    public Label issueNoLabel;

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
        /*
        clickIssue();
        clickSubMenu("Extraction Details");
        */
        String subURL = "Business/Issue/Products/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Issue Product Extraction Details");
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
