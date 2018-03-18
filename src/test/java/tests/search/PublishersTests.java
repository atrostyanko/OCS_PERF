package tests.search;

import com.reporting.ExtentManager;
import pages.publisher.PublisherInquiryPage;
import pages.search.PublisherSearchPage;
import pages.search.PublisherSearchPage.SearchOptions;
import pages.search.PublisherSearchPage.SearchFields;

import java.util.Properties;

public class PublishersTests {
    private ExtentManager eReports;
    private Properties prop;

    public PublishersTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    //=== Tests
    private void searchPublisherTest(SearchOptions option, SearchFields field, String value) {
        eReports.createNode("Search -> Publishers -> " + option + " by " + field + ".",
                "Verify Search " + option + " Publishers by " + field + ".");

        //=== Journal Sequence No.
        PublisherSearchPage publisherSearchPage = new PublisherSearchPage();
        eReports.compareNotNULL(publisherSearchPage,
                "Open 'Search -> Publishers' search page.");

        eReports.compareTrue(publisherSearchPage.selectSearchOption(option),
                "Set '" + option + "' search option.");

        eReports.compareTrue(publisherSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        PublisherInquiryPage publisherInquiryPage = (PublisherInquiryPage) publisherSearchPage.clickSearchButton(option);
        eReports.compareNotNULL(publisherInquiryPage,
                "Click 'Search' button and verify that Publisher Inquiry page was opened.");

        eReports.compareTrue(publisherInquiryPage.checkValue(field, value),
                "Verify that " + value + " is displayed in the '" + field + "' field.");
    }

    public void FullPublishersTests() {
        //=== Journal Publishers ===============================
        //====== Publ. Name
        searchPublisherTest(SearchOptions.JournalPublishers,
                SearchFields.PublName,
                prop.getProperty("journalPublisherSearchName"));
        //====== Address =
        //====== Publ. Number = AAN04
        //ToDo: Bug in the APP
        /*
        searchPublisherTest(SearchOptions.JournalPublishers,
                SearchFields.PublNumber,
                prop.getProperty("journalPublisherSearchNumber"));
        */

        //=== Book Publishers ==================================
        //====== Publ. Name
        searchPublisherTest(SearchOptions.BookPublishers,
                SearchFields.PublName,
                prop.getProperty("bookPublisherSearchName"));
        //====== Address =
        //====== Publ. Number = VA001

        //=== Sample Journal Publishers ========================
        //====== Publ. Name
        searchPublisherTest(SearchOptions.SampleJournalPublishers,
                SearchFields.PublName,
                prop.getProperty("sampleJournalPublishersSearchName"));
        //====== Address
        //====== Publ. Number = AAOIY

        //=== Covered Journal Publishers
        //====== Publ. Name
        searchPublisherTest(SearchOptions.CoveredJournalPublishers,
                SearchFields.PublName,
                prop.getProperty("coveredJournalPublishersSearchName"));
        //====== Address
        //====== Publ. Number = ACB12

        //=== Sample Book Publishers
        //====== Publ. Name
        searchPublisherTest(SearchOptions.SampleBookPublishers,
                SearchFields.PublName,
                prop.getProperty("sampleBookPublishersSearchName"));
        //====== Address
        //====== Publ. Number = AAYHL

        //=== Covered Book Publishers
        //====== Publ. Name = SOLID WASTE ASSOCIATION NORTH AMERICA
        searchPublisherTest(SearchOptions.CoveredBookPublishers,
                SearchFields.PublName,
                prop.getProperty("coveredBookPublishersSearchName"));
        //====== Address
        //====== Publ. Number = YD550
    }

    public void PublishersTest_BVT() {
        eReports.createNode("Search -> Publishers page.",
                "Verify Search Publishers page.");

        PublisherSearchPage publisherSearchPage = new PublisherSearchPage();
        eReports.compareNotNULL(publisherSearchPage,
                "Open 'Search -> Publishers' search page.");

    }
}
