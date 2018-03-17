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
        ExtentManager.flush();
    }

    @Test
    public void publisherTests() {
        ExtentManager.createTest("PUBLISHER Tests.", "Verify all items from PUBLISHER menu.");

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

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void journalTests() {
        ExtentManager.createTest("JOURNAL Tests.", "Verify all items from JOURNAL menu.");

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
        //====== Delete Sample Book
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

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void issueTests() {
        ExtentManager.createTest("ISSUE Tests.", "Verify all items from ISSUE menu.");

        MainPage mainPage = new LoginPage_Tests(eReports, prop).login();
        IssueTests issueTests = new IssueTests();

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


        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void searchTest() {
        ExtentManager.createTest("SEARCH Tests.", "Verify all items from SEARCH menu.");

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

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
}
