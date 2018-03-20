package pages.conference;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Button;
import org.openqa.selenium.support.FindBy;

public class ConferenceEditPage extends BaseConferencePage {
    @FindBy(css = "input[src *='submit_button.gif']")
    public Button submitBtn;

    //====== Constructor ==============================
    public ConferenceEditPage() {
        super(true);
    }

    public ConferenceEditPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickConf();
        clickSubMenu("Conference Edit");
        */
        String subURL = "Business/Conference/Edit/prompt.jsp";
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
