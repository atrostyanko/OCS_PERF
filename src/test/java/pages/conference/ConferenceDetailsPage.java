package pages.conference;

import com.webtestsbase.WebDriverFactory;
import com.webtestsbase.commonElements.elements.Label;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.issue.BaseIssuePage;
import pages.search.ConferenceSearchPage.SearchFields;


public class ConferenceDetailsPage extends BaseConferencePage {
    @FindBy (xpath = ".//span[contains(text(), 'Conference Title')]")
    @CacheLookup
    public Label conferenceTitle;

    @FindBy (xpath = ".//span[contains(text(), 'Host Organization')]")
    @CacheLookup
    public Label hostOrganization;

    //====== Constructor ==============================
    public ConferenceDetailsPage() {
        super(true);
    }
    public ConferenceDetailsPage(boolean openFromMenu) {
        super(openFromMenu);
    }

    @Override
    public void openPage() {
        /*
        clickConf();
        clickSubMenu("Conference Details");
        */
        String subURL = "Business/Conference/Details/prompt.jsp";
        WebDriverFactory.navigateTo(subURL);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.getText().equals("Conference Details");
    }

    //===== Check methods ==============================================================================================
    public boolean checkValue(SearchFields field, String value) {
        String fieldValue = "";
        switch (field.value()) {
            case "searchConferenceNo":
                fieldValue = WebDriverFactory.getElementValue(conferenceNoLabel.asWebElement());
                break;
            case "conferenceTitle":
                fieldValue = WebDriverFactory.getElementValue(conferenceTitle.asWebElement());
                break;
            case "hostOrganization":
                fieldValue = WebDriverFactory.getElementValue(hostOrganization.asWebElement());
                break;
            default:
                fieldValue = "";
                break;
        }
        return fieldValue.equals(value);
    }

}
