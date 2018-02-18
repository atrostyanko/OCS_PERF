package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;

public class AddSampleBookPage extends MainPublisherPage {
    @FindBy(xpath = ".//b[.= 'Add New Sample Book']")
    private Label addNewSampleBookLabel;

    @FindBy(name = "isbn")
    public TextInput isbn;

    @FindBy(name = "fullTitle")
    public TextInput fullTitle;

    @FindBy(name = "pubContact")
    public TextInput pubContact;

    @FindBy(name = "sampleSource")
    public TextInput sampleSource;

    @FindBy(css = "input[name = 'newRecordType'][value='REQUESTED']")
    public CheckBox requestedOrdered;

    @FindBy(css = "input[name = 'newRecordType'][value='RECEIVED']")
    public CheckBox  ReceivedUnsolicited;

    @FindBy(name = "pubYear")
    public TextInput pubYear;

    @FindBy(name = "authorAddress[0].name")
    public TextInput authorAddress0;

    @FindBy(name = "bookDOI")
    public TextInput bookDOI;

    //====== Constructor ==============================
    public AddSampleBookPage() {
        super(true);
    }

    public AddSampleBookPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Add Sample Book");
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

    public BookInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new BookInquiryPage(false)
                : null;
    }

}
