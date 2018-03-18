package tests;

import com.configuration.TestsConfig;
import com.configuration.properties.AllProperties;
import com.configuration.properties.PropertiesLoader;
import com.configuration.properties.PropertyFile;
import com.reporting.ExtentManager;
import com.webtestsbase.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.MainPage;
import tests.conference.ConferenceTests;
import tests.issue.IssueTests;
import tests.journal.JournalTests;
import tests.loginPage.LoginPage_Tests;
import tests.miscellaneous.MiscellaneousTests;
import tests.publisher.PublisherTests;
import tests.reports.ReportsTests;
import tests.search.SearchTests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@PropertyFile("testData/bvt.properties")
public class BVT_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("OCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void publisherTests() {
        eReports.createTest("PUBLISHER Tests.", "Verify all items from PUBLISHER menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        PublisherTests publisherTest = new PublisherTests(eReports, prop);

        //=== Publisher Inquiry
        publisherTest.publisherInquiryTest_BVT();

        //=== Publisher Edit
        //===== Edit Publisher
        publisherTest.publisherEditPublisherTest_BVT();

        //===== Add Publisher
        publisherTest.publisherAddPublisherTest_BVT();

        //===== Add Sample Publisher
        publisherTest.publisherAddSamplePublisherTest_BVT();

        //===== Edit Sample Publisher
        publisherTest.publisherEditSamplePublisherTest_BVT();

        //=== List of Journals
        publisherTest.publisherJournalListTest_BVT();

        //=== Royalty
        //===== Royalty Inquiry
        publisherTest.publisherRoyaltyInquiryTest_BVT();

        //===== Edit Royalty
        publisherTest.publisherEditRoyaltyTest_BVT();

        //===== List journal Royalties
        publisherTest.publisherListJournalRoyaltiesTest_BVT();

        //===== Edit Multiple journal Royalties

        //=== Add Sample book
        publisherTest.publisherAddSampleBookTest_BVT();

        //=== Add Sample journal
        publisherTest.publisherAddSampleJournalTest_BVT();

        //=== Add a Serie
        publisherTest.publisherAddNewSerieTest_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void journalTests() {
        eReports.createTest("JOURNAL Tests.", "Verify all items from JOURNAL menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        JournalTests journalTest = new JournalTests(eReports, prop);

        //=== Journal Inquiry
        journalTest.journalInquiryTest_BVT();

        //=== Edit
        //===== Edit Covered Journal
        journalTest.journalEditCoveredJournalTest_BVT();
        //===== Edit Sample Journal
        journalTest.journalEditSampleJournalTest_BVT();
        //===== Edit Book
        journalTest.journalEditBookTest_BVT();
        //===== Edit Sample Book
        journalTest.journalEditSampleBookTest_BVT();
        //===== Edit Series
        journalTest.journalEditSeriesTest_BVT();

        //=== Delete
        //====== Delete Journal
        //====== Delete Sample Journal
        journalTest.deleteSampleJournalTest_BVT();
        //====== Delete Sample Book
        journalTest.deleteSampleBookTest_BVT();
        //====== Delete Series

        //=== Prod. Codes - Subj. Categories
        journalTest.JournalProductCodesInquiryTest_BVT();

        //=== Edit Product Codes
        //===== For Journals
        journalTest.journalEditProductCodesForJournalsTest_BVT();
        //===== For Sample Journals
        journalTest.journalEditProductCodesForSampleJournalsTest_BVT();
        //===== For Books
        journalTest.journalEditProductCodesForBooksTest_BVT();
        //===== For Sample Books
        journalTest.journalEditProductCodesForSampleBooksTest_BVT();
        //===== For Series
        journalTest.journalEditProductCodesForSeriesTest_BVT();

        //=== Edit Subject Categories
        //===== For Journals
        journalTest.journalEditSubjectCategoriesForJournalsTest_BVT();
        //===== For Sample Journals
        journalTest.journalEditSubjectCategoriesForSampleJournalsTest_BVT();
        //===== For Books
        journalTest.journalEditSubjectCategoriesForBooksTest_BVT();
        //===== For Sample Books
        journalTest.journalEditSubjectCategoriesForSampleBooksTest_BVT();
        //===== For Series
        journalTest.journalEditSubjectCategoriesForSeriesTest_BVT();

        //=== Prod. Codes History
        journalTest.journalProductCodeHistoryTest_BVT();

        //=== Sophia Journals Maintenance
        //ToDo: Не понятно пока как сделать

        //=== Subject Category History
        journalTest.journalSubjectCategoryHistoryTest_BVT();

        //=== View Issues (CRDX)
        journalTest.journalViewIssuesTest_BVT();

        //=== Royalty
        //===== Royalty Inquiry
        journalTest.journalRoyaltyInquiryTest_BVT();
        //===== Edit Royalty
        journalTest.journalEditRoyaltyTest_BVT();

        //=== Subscriptions
        //===== Subscription Details
        journalTest.journalSubscriptionDetailsTest_BVT();
        //===== View History
        journalTest.journalSubscriptionHistoryTest_BVT();
        //===== View / Edit History
        journalTest.journalSubscriptionViewEditHistoryTest_BVT();

        //=== Journal Changes
        journalTest.journalChangesTest_BVT();

        //=== Edit XRef Notes
        journalTest.journalEditXRefNotesTest_BVT();

        //=== Issue Login
        journalTest.journalIssueLoginTest_BVT();

        //=== Transform a Sample Book
        journalTest.journalTransformingBookTest_BVT();

        //=== Transform a Sample Journal
        journalTest.journalTransformingSampleJournalTest_BVT();

        //=== Journal XRef
        //===== Alter Titles
        journalTest.journalAlterTitlesTest_BVT(prop.getProperty("alterTitles_JournalSequence"));

        //===== Drop/Cease/Suspend
        journalTest.dropSuspendCeaseTest_BVT(prop.getProperty("dropSuspendCease_JournalSequence"));

        //===== Absorb
        journalTest.absorbTest_BVT(prop.getProperty("absorb_JournalSequence"));

        //===== Merge
        journalTest.mergeTest_BVT(prop.getProperty("merge_JournalSequence"));

        //===== Split
        journalTest.splitTest_BVT(prop.getProperty("split_JournalSequence"));

        //===== Title Changes
        journalTest.titleChangesTest_BVT(prop.getProperty("titleChanges_JournalSequence1"));

        //===== Add Variants
        journalTest.addVariantsTest_BVT(prop.getProperty("addVariants_JournalSequence"));

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void issueTests() {
        eReports.createTest("ISSUE Tests.", "Verify all items from ISSUE menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        IssueTests issueTests = new IssueTests(eReports, prop);

        //=== Issue Details
        issueTests.issueDetailsTest_BVT();

        //=== Edit Issue
        issueTests.editIssueTest_BVT();

        //=== List All Articles
        issueTests.listAllArticlesTest_BVT();

        //=== Extraction Details
        issueTests.extractionDetailsTest_BVT();

        //=== Article
        //===== View Biblio
        //ToDo: пустая страница
        //issueTests.viewBiblioTest_BVT();

        //=== Label Reprint
        issueTests.labelReprintTest_BVT();

        //=== Re-Print Journal Labels
        issueTests.printJournalLabelsTest_BVT();

        //=== Send Issue to Image Capture
        issueTests.sendIssueToImageCaptureTest_BVT();

        //=== Issue Hold
        issueTests.issueHoldTest_BVT();

        //=== Issue Tracking
        issueTests.issueTrackingPageTest_BVT();

        //=== Multiple Issues Tracking
        issueTests.multipleIssuesTrackingTest_BVT();

        //=== Claiming
        //===== Candidates
        issueTests.candidatesTest_BVT();

        //===== Active Claim
        issueTests.activeClaimTest_BVT();

        //===== History
        issueTests.claimingHistoryTest_BVT();

        //===== Claim Request
        issueTests.ClaimRequestTest_BVT();


        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void conferenceTests() {
        eReports.createTest("Conference Tests.", "Verify all items from Conf. menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        ConferenceTests conferenceTests = new ConferenceTests(eReports, prop);

        conferenceTests.conferenceDetailsTest_BVT();

        conferenceTests.conferenceInputTest_BVT();

        conferenceTests.conferenceEditTest_BVT();

        conferenceTests.linkArticlesTest_BVT();

        conferenceTests.linkSampleBooksTest_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void searchTest() {
        eReports.createTest("SEARCH Tests.", "Verify all items from SEARCH menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        SearchTests searchTests = new SearchTests(eReports, prop);

        //=== Publications
        searchTests.publicationsTest_BVT();

        //=== Publishers
        searchTests.publishersTest_BVT();

        //=== Issues
        searchTests.issuesTest_BVT();

        //=== Conferences
        searchTests.conferencesTest_BVT();

        //=== Product Codes
        searchTests.productCodesTest_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void Miscellaneous() {
        eReports.createTest("SEARCH Tests.", "Verify all items from SEARCH menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        MiscellaneousTests miscellaneousTests = new MiscellaneousTests(eReports, prop);

        miscellaneousTests.reportsTest();

        miscellaneousTests.dictionaryTest();

        miscellaneousTests.printerSetupTest();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
}
