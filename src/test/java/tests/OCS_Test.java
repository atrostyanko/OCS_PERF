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

        //=== Publisher Inquiry
        new PublisherTest().publisherInquiryTest();

        //=== Publisher Edit
        //===== Edit Publisher
        new PublisherTest().publisherEditPublisherTest();

        //===== Add Publisher
        new PublisherTest().publisherAddPublisherTest();

        //===== Add Sample Publisher
        new PublisherTest().publisherAddSamplePublisherTest();

        //===== Edit Sample Publisher
        new PublisherTest().publisherEditSamplePublisherTest();

        //=== List of Journals
        new PublisherTest().publisherJournalListTest();

        //=== Royalty
        //===== Royalty Inquiry
        new PublisherTest().publisherAddSampleBookTest();

        //=== Add Sample Book
        new PublisherTest().publisherAddSampleBookTest();

        //=== Add Sample Journal

        //=== Add a Serie
        new PublisherTest().publisherAddNewSerieTest();

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
