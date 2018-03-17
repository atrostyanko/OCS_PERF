package pages.publisher;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public abstract class MainPublisherPage extends MainPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public WebElement pageTitle;

    @FindBy (xpath = ".//span[contains(text(), 'Publisher Number')]")
    private WebElement publisherNumber;

    @FindBy(name = "publisherKey")
    public TextInput publisherKey;

    @FindBy(css = "input[name='publisherKeyType'][value='J']")
    public CheckBox journal;

    @FindBy(css = "input[name='publisherKeyType'][value='B']")
    public CheckBox book;

    @FindBy(css = "[src *= 'Images/submit_changes.gif']")
    public Button submitChanges;

    @FindBy(name = "confirmButton")
    public Button confirmButton;

    //====== Constructor ==============================
    public MainPublisherPage() {
        super(true);
    }

    public MainPublisherPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    //===== Set methods ================================================================================================
    public boolean setPublisherKey(String sValue) {
        return publisherKey.setText(sValue);
    }

    //===== Click methods ==============================================================================================
    public boolean clickSubmit() {
        if (submitBtn.click()) {
            return WebDriverFactory.waitElementIsVisible(publisherNumber);
        }
        return false;
    }
    public boolean clickSubmitChanges() {
        return submitChanges.click();
    }
}
