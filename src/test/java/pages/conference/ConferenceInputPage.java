package pages.conference;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class ConferenceInputPage extends BaseConferencePage {
    @FindBy(css = "input[src *='submit_button.gif']")
    private Button submitBtn;

    //====== Constructor ==============================
    public ConferenceInputPage() {
        super(true);
    }

    public ConferenceInputPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickConf();
        clickSubMenu("Conference Input");
        */
        String subURL = "ConferenceRetrieveDetails.do?conferenceNumber=&conferenceTitle=";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isSearchPageOpened() {
        return conferenceNumber.isDisplayed() && submitBtn.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Conference Input / Edit");
    }
}
