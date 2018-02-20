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

        //=== Add a Serie
        publisherTest.publisherAddNewSerieTest();

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
