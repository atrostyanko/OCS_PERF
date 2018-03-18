package pages.conference;

import com.webtestsbase.commonElements.elements.Button;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

public class BaseConferencePage extends MainPage {
    @FindBy (css = ".BackgroundBigHeader td[align='center'] b")
    public Label pageTitle;

    @FindBy(name = "conferenceNumber")
    public TextInput conferenceNumber;

    @FindBy (xpath = ".//span[contains(text(), 'Conference No')]")
    public Label conferenceNoLabel;

    @FindBy (name="submit")
    public TextInput submitBtn;

    @FindBy(css = "[src *= 'Images/submit_changes.gif']")
    public Button submitChanges;

    @FindBy(name = "confirmButton")
    public Button confirmButton;

    //====== Constructor ==============================
    public BaseConferencePage() {
        super(true);
    }
    public BaseConferencePage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isSearchPageOpened() {
        return conferenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setConference(String sValue) {
        return conferenceNumber.setText(sValue);
    }
}
