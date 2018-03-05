package tests.search;

import com.reporting.ExtentManager;
import pages.publisher.BookInquiryPage;
import pages.search.BaseSearchPage.SearchFields;
import pages.search.BaseSearchPage.SearchOptions;
import pages.journal.JournalInquiryPage;
import pages.search.PublicationsSearchPage;
import tests.OCS_Test;

import java.util.Properties;

public class SearchTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public SearchTests() {
    }

    public void PublicationsTests() {
        searchJournalTest(SearchOptions.ALL,
                SearchFields.Title11,
                prop.getProperty("journalSearchTitle11"));

        searchJournalTest(SearchOptions.JOURNALS,
                SearchFields.Title29,
                prop.getProperty("journalSearchTitle29"));

        searchJournalTest(SearchOptions.ACTIVEJOURNALS,
                SearchFields.Title20,
                prop.getProperty("journalSearchTitle20"));

        searchJournalTest(SearchOptions.SERIES,
                SearchFields.FullTitle,
                prop.getProperty("journalSearchFullTitle"));

        searchJournalTest(SearchOptions.SAMPLEJOURNALS,
                SearchFields.JournalSequence,
                prop.getProperty("journalSearchSequence"));

        searchJournalTest(SearchOptions.ALLJOURNALS,
                SearchFields.ISOTitle,
                prop.getProperty("journalSearchISOTitle"));

        searchJournalTest(SearchOptions.ALLJOURNALS,
                SearchFields.ISSN,
                prop.getProperty("journalSearchISSN"));


        searchBookTest(SearchOptions.SAMPLEBOOKS,
                SearchFields.JournalSequence,
                prop.getProperty("bookSearchSequence"));

        searchBookTest(SearchOptions.ALLBOOKS,
                SearchFields.FullTitle,
                prop.getProperty("bookSearchFullTitle"));
    }
    public void searchJournalTest(SearchOptions option, SearchFields field, String value) {

        ExtentManager.createNode("Search -> Publications -> " + option + " by " + field + ".",
                "Verify Search " + option + " Publication by " + field + ".");

        //=== Journal Sequence No.
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.selectSearchOption(option),
                "Set '" + option + "' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(option);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
    }
    public void searchBookTest(SearchOptions option, SearchFields field, String value) {

        ExtentManager.createNode("Search -> Publications -> " + option + " by " + field + ".",
                "Verify Search " + option + " Publication by " + field + ".");

        //=== Journal Sequence No.
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.selectSearchOption(option),
                "Set '" + option + "' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.setValue(field, value),
                "Set " + value + " to the '" + field + "' field.");

        BookInquiryPage bookInquiryPage = (BookInquiryPage) publicationsSearchPage.clickSearchButton(option);
        ExtentManager.compareNotNULL(bookInquiryPage,
                "Click 'Search' button and verify that Book Inquiry page was opened.");
    }

    public void publishersTest() {
        ExtentManager.createNode("Search -> Publishers Page.", "Verify Search Publishers Page.");
    }
    public void issuesTest() {
        ExtentManager.createNode("Search -> Issues Page.", "Verify Search Issues Page.");
    }
    public void conferencesTest() {
        ExtentManager.createNode("Search -> Conferences Page.", "Verify Search Conferences Page.");
    }
    public void productCodesTest() {
        ExtentManager.createNode("Search -> Product Codes Page.", "Verify Search Product Codes Page.");
    }
}
