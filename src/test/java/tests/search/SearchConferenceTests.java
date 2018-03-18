package tests.search;

import com.reporting.ExtentManager;
import pages.conference.ConferenceDetailsPage;
import pages.search.ConferenceSearchPage;
import pages.search.ConferenceSearchPage.SearchFields;
import pages.search.SearchOCSPage;

import java.util.Properties;

public class SearchConferenceTests {
    private ExtentManager eReports;
    private Properties prop;

    public SearchConferenceTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    //=== Tests
    private void searchConferenceTest(SearchFields field, String value, boolean listSearch) {
        eReports.createNode("Search -> Conferences -> by " + field + ".",
                "Verify Search Conferences by " + field + ".");

        ConferenceSearchPage conferenceSearchPage = new ConferenceSearchPage();
        eReports.compareNotNULL(conferenceSearchPage,
                "Open 'Search -> Conferences' search page.");

        eReports.compareTrue(conferenceSearchPage.beginsWith.set(),
                "Set 'Begins with' checkbox.");

        eReports.compareTrue(conferenceSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        if (listSearch) {
            SearchOCSPage searchOCSPage = (SearchOCSPage) conferenceSearchPage.clickSearchButton(listSearch);

            eReports.compareNotNULL(searchOCSPage,
                    "Click 'Search' button and verify that Search OCS page was opened.");

        } else {
            ConferenceDetailsPage conferenceDetailsPage = (ConferenceDetailsPage) conferenceSearchPage.clickSearchButton(listSearch);

            eReports.compareNotNULL(conferenceDetailsPage,
                    "Click 'Search' button and verify that Conference Details page was opened.");

            eReports.compareTrue(conferenceDetailsPage.checkValue(field, value),
                    "Verify that " + value + " is displayed in the '" + field + "' field.");
        }
    }

    public void FullConferenceTests() {
        searchConferenceTest(SearchFields.ConferenceNumber,
                prop.getProperty("searchConferenceNo"), false);

        searchConferenceTest(SearchFields.ConferenceTitle,
                prop.getProperty("conferenceTitle"), false);

        searchConferenceTest(SearchFields.HostOrganization,
                prop.getProperty("hostOrganization"), true);

        searchConferenceTest(SearchFields.Sponsors,
                prop.getProperty("sponsors"), true);
    }
    public void ConferenceTest_BVT() {
        eReports.createNode("Search -> Conferences page.",
                "Verify Search Conferences by page.");

        ConferenceSearchPage conferenceSearchPage = new ConferenceSearchPage();
        eReports.compareNotNULL(conferenceSearchPage,
                "Open 'Search -> Conferences' search page.");

    }
}
