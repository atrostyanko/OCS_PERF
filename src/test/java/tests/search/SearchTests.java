package tests.search;

import com.reporting.ExtentManager;
import enums.SearchOptions;
import pages.journal.JournalInquiryPage;
import pages.search.PublicationsSearchPage;
import tests.OCS_Test;

import java.util.Properties;

public class SearchTests {
    public static ExtentManager eReports = OCS_Test.eReports;
    public static Properties prop = OCS_Test.prop;

    public SearchTests() {
    }

    public void searchJournalBySequenceNoTest() {
        String journalSearchSequence = prop.getProperty("journalSearchSequence");

        ExtentManager.createNode("Search -> Publications -> Journal by Sequence No.",
                "Verify Search Journal Publication by Sequence No.");

        //=== Journal Sequence No.
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.journalSequenceNo.setText(journalSearchSequence),
                "Set " + journalSearchSequence + " to the 'Journal Sequence No.' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(SearchOptions.JOURNALS);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
    }
    public void searchJournalByFullTitleTest() {
        String journalSearchFullTitle = prop.getProperty("journalSearchFullTitle");

        ExtentManager.createNode("Search -> Publications -> Journal by Full Title.",
                "Verify Search Journal Publication by Full Title.");

        //=== Full Title
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.fullTitle.setText(journalSearchFullTitle),
                "Set " + journalSearchFullTitle + " to the 'Full Title' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(SearchOptions.JOURNALS);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");

    }
    public void searchJournalByTitle29Test() {
        String journalSearchTitle29 = prop.getProperty("journalSearchTitle29");

        ExtentManager.createNode("Search -> Publications -> Journal by Title 29.",
                "Verify Search Journal Publication by Title 29.");

        //=== Title 29
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.title29.setText(journalSearchTitle29),
                "Set " + journalSearchTitle29 + " to the 'Title 29' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(SearchOptions.JOURNALS);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
    }
    public void searchJournalByTitle20Test() {
        String journalSearchTitle20 = prop.getProperty("journalSearchTitle20");

        ExtentManager.createNode("Search -> Publications -> Journal by Title 20.",
                "Verify Search Journal Publication by Title 20.");

        //=== Title 20
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.title20.setText(journalSearchTitle20),
                "Set " + journalSearchTitle20 + " to the 'Title 20' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(SearchOptions.JOURNALS);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
    }
    public void searchJournalByTitle11Test() {
        String journalSearchTitle11 = prop.getProperty("journalSearchTitle11");

        ExtentManager.createNode("Search -> Publications -> Journal by Title 11.",
                "Verify Search Journal Publication by Title 11.");

        //=== Title 11
        PublicationsSearchPage publicationsSearchPage = new PublicationsSearchPage();
        ExtentManager.compareNotNULL(publicationsSearchPage,
                "Open 'Search -> Publications' search page.");

        ExtentManager.compareTrue(publicationsSearchPage.allJournalsOption.set(),
                "Set 'Journals' search option.");

        ExtentManager.compareTrue(publicationsSearchPage.title11.setText(journalSearchTitle11),
                "Set " + journalSearchTitle11 + " to the 'Title 11' field.");

        JournalInquiryPage journalInquiryPage = (JournalInquiryPage) publicationsSearchPage.clickSearchButton(SearchOptions.JOURNALS);
        ExtentManager.compareNotNULL(journalInquiryPage,
                "Click 'Search' button and verify that Journal Inquiry page was opened.");
    }
    public void searchJournalByISOTitleTest() {
        String journalSearchISOTitle = prop.getProperty("journalSearchISOTitle");

        ExtentManager.createNode("Search -> Publications Page.", "Verify Search Journal Publication by ISO Title.");

    }
    public void searchJournalByISSNTest() {
        String journalSearchISSN = prop.getProperty("journalSearchISSN");

        ExtentManager.createNode("Search -> Publications Page.", "Verify Search Journal Publication by ISSN.");
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
