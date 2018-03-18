package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.search.IssueSearchPage.SearchFields;

public class IssueDetailsPage extends BaseIssuePage {
    @FindBy (xpath = ".//b[contains(text(), 'Journal Seq.')]")
    public Label journalSeq;

    @FindBy (xpath = ".//b[contains(text(), 'Accession')]")
    public Label accession;

    @FindBy (name = "authorCheck")
    @CacheLookup
    private CheckBox authorCheck;

    @FindBy (xpath = ".//span[contains(text(), 'Conferences Linked')]")
    @CacheLookup
    private WebElement conferencesLinked;

    @FindBy (xpath = ".//span[contains(text(), 'Issue Product Codes')]")
    @CacheLookup
    private WebElement issueProductCodes;

    @FindBy (css = "a.NavBarLinks[href *= 'IssueDetails.do?']")
    @CacheLookup
    private Button issueDetailsTab;

    @FindBy (css = "a.NavBarLinks[href*='IssueListAllArticles.do?']")
    @CacheLookup
    private Button listArticlesTab;

    @FindBy (css = "a.NavBarLinks[href *= 'IssueTrackingRetrieve.do?']")
    @CacheLookup
    private Button issueTrackingRetrieveTab;

    //====== Constructor ==============================
    public IssueDetailsPage() {
        super(true);
    }
    public IssueDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickIssue();
        clickSubMenu("Issue Details");
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Issue Details");
    }

    //===== Get methods ================================================================================================
    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(issueNoLabel.asWebElement());
        }
        return false;
    }
    public boolean openIssueDetailsTab() {
        if (issueDetailsTab.click()) {
            return WebDriverFactory.waitElementIsVisible(conferencesLinked);
        }
        return false;
    }
    public boolean openListArticlesTab() {
        if (listArticlesTab.click()) {
            return WebDriverFactory.waitElementIsVisible(authorCheck.asWebElement());
        }
        return false;
    }
    public boolean openIssueTrackingRetrieveTab() {
        if (issueTrackingRetrieveTab.click()) {
            return WebDriverFactory.waitElementIsVisible(issueProductCodes);
        }
        return false;
    }

    //===== Check methods ==============================================================================================
    public boolean checkValue(SearchFields field, String value) {
        String fieldValue = "";
        switch (field.value()) {
            case "issueNumber":
                fieldValue = WebDriverFactory.getElementValue(issueNoLabel.asWebElement());
                break;
            case "accession":
                fieldValue = WebDriverFactory.getElementValue(accession.asWebElement());
                break;
            default:
                fieldValue = "";
                break;
        }
        return fieldValue.equals(value);
    }
}
