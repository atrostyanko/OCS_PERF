package tests.search;

import com.reporting.ExtentManager;
import pages.journal.JournalInquiryPage;
import pages.search.PublicationsSearchPage;
import tests.OCS_Test;

import java.util.Properties;

public class SearchTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public SearchTests() {
    }

    public void publicationsTest() {
        String journalSearchSequence = prop.getProperty("journalSearchSequence");
        String journalSearchFullTitle = prop.getProperty("journalSearchFullTitle");
        String journalSearchTitle29 = prop.getProperty("journalSearchTitle29");
        String journalSearchTitle20 = prop.getProperty("journalSearchTitle20");
        String journalSearchTitle11 = prop.getProperty("journalSearchTitle11");
        String journalSearchISOTitle = prop.getProperty("journalSearchISOTitle");
        String journalSearchISSN = prop.getProperty("journalSearchISSN");

        ExtentManager.createNode("Search -> Publications Page.", "Verify Search Publications Page.");

        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.journalSequenceNo.setText(journalSearchSequence),
                "Set " + journalSearchSequence + " to the 'Journal Sequence No.' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton();
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
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
