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

public class IssueDetailsPage extends MainPage {
    @FindBy (name = "accession")
    @CacheLookup
    private TextInput accession;

    @FindBy (name = "pubYear")
    @CacheLookup
    private TextInput pubYear;

    @FindBy (name = "issueNo")
    @CacheLookup
    private TextInput issueNo;

    @FindBy (xpath = ".//b[.='DF Issueno']")
    @CacheLookup
    private Label DFIssueno;

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
        return accession.isDisplayed() && pubYear.isDisplayed() && issueNo.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setAccession(String sValue) {
        return accession.setText(sValue);
    }
    public boolean setPubYear(String sValue) {
        return pubYear.setText(sValue);
    }
    public boolean setIssueNo(String sValue) {
        return issueNo.setText(sValue);
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
