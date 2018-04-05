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
import tests.misc.MiscTests;
import tests.request.RequestTests;
import tests.ut.UtTests;
import tests.utSequences.UTSequencesTests;

import java.util.Properties;

/**
 * Created by Alexandr Trostyanko.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@PropertyFile("testData/bvt.properties")
public class BVT1_Test {
    public static ExtentManager eReports;
    private static WebDriverFactory webDriverFactory;

    @AllProperties
    public static Properties prop;

    @BeforeClass
    public static void beforeClass() {
        eReports = new ExtentManager(webDriverFactory);
        eReports.setFolderPath(TestsConfig.getConfig().getReportsPath());
        eReports.GetExtent("GCS Performance Test.");
        webDriverFactory.startBrowser(true);
        PropertiesLoader.populate(new BVT1_Test());
    }

    @AfterClass
    public static void afterClass() {
        webDriverFactory.finishBrowser();
        eReports.flush();
    }

    @Test
    public void requestTests() {
        eReports.createTest("REQUEST Tests.", "Verify all items from REQUEST menu.");

        MainPage mainPage = new LoginPage_Tests(webDriverFactory, eReports, prop).login();
        RequestTests requestTests = new RequestTests(eReports, prop);

        requestTests.RequestDetails_BVT();
        requestTests.EditRequest_BVT();
        requestTests.AddRequest_BVT();
        requestTests.ViewAllRequests_BVT();
        requestTests.RequestsReadyForRelease_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
/*
    @Test
    public void utTests() {
        eReports.createTest("UT Tests.", "Verify all items from UT menu.");

        MainPage mainPage = new LoginPage_Tests(webDriverFactory, eReports, prop).login();
        UtTests utTests = new UtTests(eReports, prop);

        utTests.UtDetails_BVT();
        utTests.AddDeleteUT_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void utSequencesTests() {
        eReports.createTest("UT Sequences Tests.", "Verify all items from UT Sequences menu.");

        MainPage mainPage = new LoginPage_Tests(webDriverFactory, eReports, prop).login();
        UTSequencesTests utSequencesTests = new UTSequencesTests(eReports, prop);

        utSequencesTests.ViewUTSequences_BVT();
        utSequencesTests.ViewDeleteUTSequences_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }

    @Test
    public void miscTests() {
        eReports.createTest("MISC. Tests.", "Verify all items from MISC menu.");

        MainPage mainPage = new LoginPage_Tests(webDriverFactory, eReports, prop).login();
        MiscTests miscTests = new MiscTests(eReports, prop);

        miscTests.Statistics_All_BVT();
        miscTests.Statistics_CorrectionId_BVT();
        miscTests.Statistics_RequestStatus_BVT();
        miscTests.Statistics_UserId_BVT();

        miscTests.PasswordChange_BVT();

        miscTests.Admin_AddUser_BVT();
        miscTests.Admin_EditUser_BVT();
        miscTests.Admin_EditGCSLimits_BVT();
        miscTests.Admin_EditGCSFields_BVT();
        miscTests.Admin_AddGCSField_BVT();

        eReports.compareTrue(mainPage.clickLogoff(), "Logoff from the APP.");
    }
*/
}
