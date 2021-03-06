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
import tests.issue.IssueTests;
import tests.journal.JournalTests;
import tests.loginPage.LoginPage_Tests;
import tests.publisher.PublisherTests;
import tests.search.SearchTests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@PropertyFile("testData/ocs.properties")
public class OCS_Test {
    public static ExtentManager eReports;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager();
        eReports.setFolderPath(TestsConfig.getConfig().getReportsPath());
        eReports.GetExtent("OCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new OCS_Test());
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
        publisherTest.publisherInquiryTest();

        //=== Publisher Edit
        //===== Edit Publisher
        publisherTest.publisherEditPublisherTest();

        //===== Add Publisher
        publisherTest.publisherAddPublisherTest();

        //===== Add Sample Publisher
        publisherTest.publisherAddSamplePublisherTest();

        //===== Edit Sample Publisher
        publisherTest.publisherEditSamplePublisherTest();

        //=== List of Journals
        publisherTest.publisherJournalListTest();

        //=== Royalty
        //===== Royalty Inquiry
        publisherTest.publisherRoyaltyInquiryTest();

        //===== Edit Royalty
        publisherTest.publisherEditRoyaltyTest();

        //===== List journal Royalties
        publisherTest.publisherListJournalRoyaltiesTest();

        //===== Edit Multiple journal Royalties

        //=== Add Sample book
        publisherTest.publisherAddSampleBookTest();

        //=== Add Sample journal
        publisherTest.publisherAddSampleJournalTest();

        //=== Add a Serie
        publisherTest.publisherAddNewSerieTest();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void journalTests() {
        eReports.createTest("JOURNAL Tests.", "Verify all items from JOURNAL menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        JournalTests journalTest = new JournalTests(eReports, prop);

        //=== Journal Inquiry
        journalTest.journalInquiryTest();

        //=== Edit Product Codes
        //===== For Journals
        journalTest.journalEditProductCodesForJournalsTest();
        //===== For Sample Journals
        journalTest.journalEditProductCodesForSampleJournalsTest();
        //===== For Books
        journalTest.journalEditProductCodesForBooksTest();
        //===== For Sample Books
        journalTest.journalEditProductCodesForSampleBooksTest();
        //===== For Series
        journalTest.journalEditProductCodesForSeriesTest();

        //=== Edit
        //===== Edit Covered Journal
        journalTest.journalEditCoveredJournalTest();
        //===== Edit Sample Journal
        journalTest.journalEditSampleJournalTest();
        //===== Edit Book
        journalTest.journalEditBookTest();
        //===== Edit Sample Book
        journalTest.journalEditSampleBookTest();
        //===== Edit Series
        journalTest.journalEditSeriesTest();

        //=== Delete
        //====== Delete Journal
        //====== Delete Sample Journal
        //====== Delete Sample Book
        //====== Delete Series

        //=== Prod. Codes - Subj. Categories
        journalTest.JournalProductCodesInquiryTest();


        //=== Edit Subject Categories
        //===== For Journals
        journalTest.journalEditSubjectCategoriesForJournalsTest();
        //===== For Sample Journals
        journalTest.journalEditSubjectCategoriesForSampleJournalsTest();
        //===== For Books
        journalTest.journalEditSubjectCategoriesForBooksTest();
        //===== For Sample Books
        journalTest.journalEditSubjectCategoriesForSampleBooksTest();
        //===== For Series
        journalTest.journalEditSubjectCategoriesForSeriesTest();

        //=== Prod. Codes History
        journalTest.journalProductCodeHistoryTest();

        //=== Sophia Journals Maintenance
        //ToDo: Не понятно пока как сделать

        //=== Subject Category History
        journalTest.journalSubjectCategoryHistoryTest();

        //=== View Issues (CRDX)
        journalTest.journalViewIssuesTest();

        //=== Royalty
        //===== Royalty Inquiry
        journalTest.journalRoyaltyInquiryTest();
        //===== Edit Royalty
        journalTest.journalEditRoyaltyTest();

        //=== Subscriptions
        //===== Subscription Details
        journalTest.journalSubscriptionDetailsTest();
        //===== View History
        journalTest.journalSubscriptionHistoryTest();
        //===== View / Edit History
        journalTest.journalSubscriptionViewEditHistoryTest();

        //=== Journal Changes
        journalTest.journalChangesTest();

        //=== Edit XRef Notes
        journalTest.journalEditXRefNotesTest();

        //=== Issue Login
        journalTest.journalIssueLoginTest();

        //=== Journal XRef
        //===== Alter Titles
        journalTest.journalAlterTitlesTest(prop.getProperty("alterTitles_JournalSequence"));

        //===== Drop/Cease/Suspend
        journalTest.dropSuspendCeaseTest(prop.getProperty("dropSuspendCease_JournalSequence"));
        journalTest.reactivateTest(prop.getProperty("dropSuspendCease_JournalSequence"));

        //===== Absorb
        journalTest.absorbTest(prop.getProperty("absorb_JournalSequence"));

        //===== Merge
        journalTest.mergeTest(prop.getProperty("merge_JournalSequence"));

        //===== Split
        journalTest.splitTest(prop.getProperty("split_JournalSequence"));
        journalTest.reactivateTest(prop.getProperty("split_JournalSequence"));

        //===== Title Changes
        journalTest.titleChangesTest(prop.getProperty("titleChanges_JournalSequence1"),
                prop.getProperty("titleChanges_JournalSequence2"));
        journalTest.reactivateTest(prop.getProperty("titleChanges_JournalSequence1"));

        //===== Add Variants
        journalTest.addVariantsTest(prop.getProperty("addVariants_JournalSequence"));
/*
        //=== Transformation Test
        //=== Create a Sample Book
        //ToDo: Creation
        //=== Transform a Sample Book
        journalTest.journalTransformingBookTest();

        //=== Create a Sample Jouranl
        //ToDo: Creation
        //=== Transform a Sample Journal
        journalTest.journalTransformingSampleJournalTest();
*/
        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void issueTests() {
        eReports.createTest("ISSUE Tests.", "Verify all items from ISSUE menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        IssueTests issueTests = new IssueTests(eReports, prop);

        //=== Issue Details
        issueTests.issueDetailsTest();

        //=== Edit Issue
        issueTests.editIssueTest();

        //=== List All Articles
        issueTests.listAllArticlesTest();

        //=== Extraction Details
        issueTests.extractionDetailsTest();

        //=== Article
        //===== View Biblio
        //ToDo: пустая страница
        //issueTests.viewBiblioTest();

        //=== Label Reprint
        issueTests.labelReprintTest();

        //=== Re-Print Journal Labels
        issueTests.printJournalLabelsTest();

        //=== Send Issue to Image Capture
        issueTests.sendIssueToImageCaptureTest();

        //=== Issue Hold
        issueTests.issueHoldTest();

        //=== Issue Tracking
        issueTests.issueTrackingPageTest();

        //=== Multiple Issues Tracking
        issueTests.multipleIssuesTrackingTest();

        //=== Claiming
        //===== Candidates
        issueTests.candidatesTest();

        //===== Active Claim
        issueTests.activeClaimTest();

        //===== History
        issueTests.claimingHistoryTest();

        //===== Claim Request
        issueTests.ClaimRequestTest();


        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void searchTest() {
        eReports.createTest("SEARCH Tests.", "Verify all items from SEARCH menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        SearchTests searchTests = new SearchTests(eReports, prop);

        //=== Publications
        searchTests.publicationsTest();

        //=== Publishers
        searchTests.publishersTest();

        //=== Issues
        searchTests.issuesTest();

        //=== Conferences
        searchTests.conferencesTest();

        //=== Product Codes
        searchTests.productCodesTest();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
}
