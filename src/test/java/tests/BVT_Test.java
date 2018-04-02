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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        ExtentManager.GetExtent("GCS Performance Test.");
        WebDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT_Test());
    }

    @AfterClass
    public static void afterClass() {
        WebDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void requestTests() {
        eReports.createTest("REQUEST Tests.", "Verify all items from REQUEST menu.");

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
}
