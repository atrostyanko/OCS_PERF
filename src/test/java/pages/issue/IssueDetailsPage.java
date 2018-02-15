package pages.issue;

import com.webtestsbase.BasePage;
import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MenuPage;

public class IssueDetailsPage extends MenuPage {
    @FindBy (name = "accession")
    private TextInput accession;

    @FindBy (name = "pubYear")
    private TextInput pubYear;

    @FindBy (name = "issueNo")
    private TextInput issueNo;

    @FindBy (name = "submit")
    private Button submitBtn;

    @FindBy (xpath = ".//b[.='DF Issueno']")
    private Label DFIssueno;


    public IssueDetailsPage() {
        super();
    }

    @Override
    public void openPage() {}

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
    public void clickSubmit() {
        if (submitBtn.click()) {
            WebDriverFactory.waitElementIsVisible(DFIssueno.asWebElement());
        }
    }
}
