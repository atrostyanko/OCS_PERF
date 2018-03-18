package pages.search;

import com.webtestsbase.commonElements.elements.CheckBox;
import com.webtestsbase.commonElements.elements.TextInput;
import org.openqa.selenium.support.FindBy;
import pages.conference.ConferenceDetailsPage;

public class ConferenceSearchPage extends BaseSearchPage {
    @FindBy(name = "conferenceNo")
    public TextInput conferenceNo;

    @FindBy(name = "beginsWith")
    public CheckBox beginsWith;

    @FindBy(name = "conferenceTitle")
    public TextInput conferenceTitle;

    @FindBy(name = "hostOrganization")
    public TextInput hostOrganization;

    @FindBy(name = "sponsors")
    public TextInput sponsors;

    @Override
    public void openPage() {
        clickSearch();
        clickSubMenu("Conferences");
    }

    @Override
    public boolean isSearchPageOpened() {
        return searchButton.isDisplayed() && conferenceNo.isDisplayed();
    }

    //===== Set methods ================================================================================================
    public boolean setValue(SearchFields field, String value) {
        TextInput textInput = null;
        switch (field.value()) {
            case "searchConferenceNo":
                textInput = conferenceNo;
                break;
            case "conferenceTitle":
                textInput = conferenceTitle;
                break;
            case "hostOrganization":
                textInput = hostOrganization;
                break;
            case "sponsors":
                textInput = sponsors;
                break;
        }
        return textInput != null
                && textInput.setText(value);
    }

    //===== Click methods ==============================================================================================
    public Object clickSearchButton(boolean listSearch) {
        Object oReturn = null;
        if (searchButton.click()) {
            if (!listSearch) {
                oReturn = new ConferenceDetailsPage(false);
            } else {
                oReturn = new SearchOCSPage(false);
            }
        }
        return oReturn;
    }

    //===== Enums ======================================================================================================
    public enum SearchFields {
        ConferenceNumber("searchConferenceNo"),
        ConferenceTitle("conferenceTitle"),
        HostOrganization("hostOrganization"),
        Sponsors("sponsors");

        private String value;

        SearchFields(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}

