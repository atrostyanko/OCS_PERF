package pages.issue;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class BaseIssuePage extends MainPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    @FindBy(name = "accession")
    @CacheLookup
    public TextInput accession;

    @FindBy (name = "pubYear")
    @CacheLookup
    public TextInput pubYear;

    @FindBy (name = "issueNo")
    @CacheLookup
    public TextInput issueNo;

    @FindBy(css = "[src *= 'Images/submit_changes.gif']")
    public Button submitChanges;

    @FindBy(name = "confirmButton")
    public Button confirmButton;

    //====== Constructor ==============================
    public BaseIssuePage() {
        super(true);
    }
    public BaseIssuePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
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
    public boolean clickSubmitChanges() {
        return submitChanges.click();
    }
}
