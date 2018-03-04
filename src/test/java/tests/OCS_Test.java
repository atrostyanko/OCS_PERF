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
        ExtentManager.setFolderPath(TestsConfig.getConfig().getReportsPath());
        ExtentManager.GetExtent("OCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new OCS_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        ExtentManager.flush();
    }

    @Test
    public void publisherTests() {
        ExtentManager.createTest("PUBLISHER Tests.", "Verify all items from PUBLISHER menu.");

        MainPage mainPage = new LoginPage_Tests().login();
        PublisherTests publisherTest = new PublisherTests();

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

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void journalTests() {
        ExtentManager.createTest("JOURNAL Tests.", "Verify all items from JOURNAL menu.");

        MainPage mainPage = new LoginPage_Tests().login();
        JournalTests journalTest = new JournalTests();
/*
        //=== Journal Inquiry
        journalTest.journalInquiryTest();

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
*/
        //=== Journal Changes
        journalTest.journalChangesTest();
/*
        //=== Edit XRef Notes
        journalTest.journalEditXRefNotesTest();

        //=== Issue Login
        journalTest.journalIssueLoginTest();

        //=== Transform a Sample Book
        journalTest.journalTransformingBookTest();
        //=== Transform a Sample Journal
        journalTest.journalTransformingSampleJournalTest();

        //=== Journal XRef
        //===== Alter Titles
        journalTest.journalAlterTitlesTest();

        //===== Drop/Cease/Suspend
        journalTest.dropSuspendCeaseTest();
        journalTest.reactivateTest();

        //===== Absorb
        journalTest.absorbTest();

        //===== Merge
        journalTest.mergeTest();

        //===== Split
        journalTest.splitTest();

        //===== Title Changes
        journalTest.titleChangesTest();

        //===== Add Variants
        journalTest.addVariantsTest();
*/
        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void issueTests() {
        ExtentManager.createTest("ISSUE Tests.", "Verify all items from ISSUE menu.");

        MainPage mainPage = new LoginPage_Tests().login();
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

        MainPage mainPage = new LoginPage_Tests().login();
        SearchTests searchTests = new SearchTests();

        //=== Publications
        searchTests.searchJournalBySequenceNoTest();
        searchTests.searchJournalByFullTitleTest();
        searchTests.searchJournalByTitle29Test();
        searchTests.searchJournalByTitle20Test();
        searchTests.searchJournalByTitle11Test();
/*
        //=== Publishers
        searchTests.publishersTest();

        //=== Issues
        searchTests.issuesTest();

        //=== Conferences
        searchTests.conferencesTest();

        //=== Product Codes
        searchTests.productCodesTest();
*/

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
}
