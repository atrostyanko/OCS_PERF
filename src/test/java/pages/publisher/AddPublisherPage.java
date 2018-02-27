package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddPublisherPage extends MainPublisherPage {
    @FindBy(css = "input[name='publisherKeyType'][value='B']")
    @CacheLookup
    public CheckBox Book;

    @FindBy(css = "input[name='publisherKeyType'][value='B']")
    @CacheLookup
    public CheckBox Journal;

    @FindBy(name = "publisherName")
    @CacheLookup
    public TextInput publisherName;

    @FindBy(name = "infoBlock[0].address.street")
    @CacheLookup
    public TextInput publisherAddressStreet;

    @FindBy(name = "infoBlock[0].address.city")
    @CacheLookup
    public TextInput publisherAddressCity;

    @FindBy(name = "infoBlock[0].address.country")
    @CacheLookup
    public WebElement publisherAddressCountry;

    @FindBy(name = "infoBlock[0].address.zipOnly[0]")
    @CacheLookup
    public TextInput publisherAddressZip;

    //====== Constructor ==============================
    public AddPublisherPage() {
        super(true);
    }
    public AddPublisherPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        clickPublisher();
        clickSubMenu("Edit");
        clickSubMenu("Add Publisher");
    }

    @Override
    public boolean isPageOpened() {
        return submitChanges.isDisplayed();
    }

    //===== Click methods ==============================================================================================
    public PublisherInquiryPage clickConfirmButton() {
        return confirmButton.click()
                ? new PublisherInquiryPage(false)
                : null;
    }

    //===== Select methods =============================================================================================
    public boolean selectCountry(String sCountryName) {
        return WebDriverFactory.selectByValue(publisherAddressCountry, sCountryName);
    }
}
