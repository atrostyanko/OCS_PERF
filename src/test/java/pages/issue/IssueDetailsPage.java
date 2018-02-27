package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class IssueDetailsPage extends BaseIssuePage {
    @FindBy (xpath = ".//b[.='DF Issueno']")
    @CacheLookup
    public Label DFIssueno;

    @FindBy (xpath = ".//b[contains(text(), 'Journal Seq.')]")
    @CacheLookup
    public Label JournalSeq;

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

    //===== Get methods ================================================================================================
    public String getElementValue(WebElement webElement) {
        return WebDriverFactory.getElementValue(webElement);
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(DFIssueno.asWebElement());
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

}
