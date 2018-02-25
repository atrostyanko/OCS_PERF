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
import tests.issue.IssueDetailsTest;
import tests.journal.JournalTest;
import tests.loginPage.LoginPage_Tests;
import tests.publisher.PublisherTest;

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
        PublisherTest publisherTest = new PublisherTest();

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
        ExtentManager.createTest("PUBLISHER Tests.", "Verify all items from PUBLISHER menu.");

        MainPage mainPage = new LoginPage_Tests().login();
        JournalTest journalTest = new JournalTest();
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
        journalTest.journalJournalProductCodeHistoryTest();

        //=== Sophia Journals Maintenance
        //ToDo: Не понятно пока как сделать

        //=== Subject Category History
        journalTest.journalJournalSubjectCatagoryHistoryTest();
*/
        //=== View Issues (CRDX)
        journalTest.journalViewIssuesTest();

        //=== Royalty
        //===== Royalty Inquiry
        //===== Edit Royalty

        //=== Subscriptions
        //===== Subscription Details
        //===== View History
        //===== View / Edit History

        //=== Journal Changes
        //=== Edit XRef Notes
        //=== Issue Login
        //=== Transform a Sample Book
        //=== Transform a Sample Journal

        //=== Journal XRef
        //===== Alter Titles
        //===== Drop/Cease/Suspend
        //===== Absorb
        //===== Merge
        //===== Split
        //===== Split
        //===== Title Changes
        //===== Add Variants

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    /*
    @Test
    public void issueTests() {
        ExtentManager.createTest("ISSUE Tests.", "Verify all items from ISSUE menu.");

        MainPage mainPage = new LoginPage_Tests().login();

        new IssueDetailsTest().issueDetailsTest();

        ExtentManager.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
    */
}
