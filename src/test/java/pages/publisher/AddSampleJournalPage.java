package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.journal.JournalInquiryPage;

public class AddSampleJournalPage extends MainPublisherPage {
    @FindBy(xpath = ".//b[.= 'Add New Serie']")
    private Label addNewSampleBookLabel;

    @FindBy(name = "issn")
    public TextInput issn;

    @FindBy(name = "isbn")
    public TextInput isbn;

    @FindBy(name = "fullTitle")
    public TextInput fullTitle;

    @FindBy(name = "country")
    public WebElement country;

    @FindBy(name = "frequency")
    public WebElement frequency;

    @FindBy(name = "sampleEvalResult")
    public WebElement sampleEvalResult;

    //====== Constructor ==============================
    public AddSampleJournalPage() {
        super(true);
    }
    public AddSampleJournalPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Add Sample Journal");
    }

    @Override
    public boolean isSearchPageOpened() {
        return publisherKey.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(submitChanges.asWebElement());
        }
        return false;
    }
    public JournalInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new JournalInquiryPage(false)
                : null;
    }

    //===== Select methods =============================================================================================
    public boolean selectCountry(String sCountryName) {
        return WebDriverFactory.selectByValue(country, sCountryName);
    }
    public boolean selectFrequency(String sFrequencyName) {
        return WebDriverFactory.selectByValue(frequency, sFrequencyName);
    }
    public boolean selectSampleEvalResult(String sSampleEvalResult) {
        return WebDriverFactory.selectByValue(sampleEvalResult, sSampleEvalResult);
    }
}
