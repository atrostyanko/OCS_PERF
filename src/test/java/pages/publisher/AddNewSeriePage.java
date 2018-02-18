package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.journal.JournalInquiryPage;

public class AddNewSeriePage extends MainPublisherPage {
    @FindBy(xpath = ".//b[.= 'Add New Serie']")
    private Label addNewSampleBookLabel;

    @FindBy(name = "issn")
    public TextInput issn;

    @FindBy(name = "title11")
    public TextInput title11;

    @FindBy(name = "title20")
    public TextInput title20;

    @FindBy(name = "title29")
    public TextInput title29;

    @FindBy(name = "fullTitle")
    public TextInput fullTitle;

    @FindBy(name = "country")
    public WebElement country;

    @FindBy(name = "frequency")
    public WebElement frequency;

    //====== Constructor ==============================
    public AddNewSeriePage() {
        super(true);
    }
    public AddNewSeriePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Add a Serie");
    }

    @Override
    public boolean isPageOpened() {
        return addNewSampleBookLabel.isDisplayed() && submitBtn.isDisplayed();
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
}
